import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Node> DEQUE = new LinkedList<>();
    static int WINDOW_SIZE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        WINDOW_SIZE = L;


        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            while (!DEQUE.isEmpty() && DEQUE.getLast().value >= value) {
                DEQUE.removeLast();
            }
            DEQUE.addLast(new Node(i, value));

            if (checkWindowSize()) {
                DEQUE.removeFirst();
            }

            sb.append(getMin()).append('\n');
//            bw.write(getMin() + " ");
        }

//        bw.flush();
//        bw.close();
        System.out.println(sb);
        br.close();
    }

    public static boolean checkWindowSize() {
        if (DEQUE.size() <= 1) return false;
        return DEQUE.getLast().index - DEQUE.getFirst().index >= WINDOW_SIZE;
    }

    public  static int getMin() {
        return DEQUE.getFirst().value;
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

//    static class Deque {
//        List<Node> nodes = new ArrayList<>();
//        int size;
//
//        public Deque(int size) {
//            this.size = size;
//        }
//
//        public void addNode(int index, int value) {
//            for (int i = nodes.size() - 1; i >= 0; i--) {
//                if (nodes.get(i).value >= value) {
//                    nodes.remove(i);
//                }
//            }
//            Node node = new Node(index, value);
//            nodes.add(node);
//
//            if (checkWindowSize()) {
//                removeFirst();
//            }
//        }
//
//        public boolean checkWindowSize() {
//            if (nodes.size() <= 1) return false;
//            return nodes.get(nodes.size() - 1).index - nodes.get(0).index >= size;
//        }
//
//        public void removeFirst() {
//            nodes.remove(0);
//        }
//
//        public int getMin() {
//            return nodes.get(0).value;
//        }
//    }
}
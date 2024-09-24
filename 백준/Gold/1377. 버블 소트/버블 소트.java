import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Node[] A = new Node[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(A, (Comparator.comparingInt(o -> o.value)));

        int maxSwap = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int swapCount = A[i].subIndex(i);
            if (swapCount > maxSwap) { maxSwap = swapCount; }
        }

        System.out.println(maxSwap + 1);
        br.close();
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int subIndex(int sortedIndex) {
            return index - sortedIndex;
        }
    }
}

//    public static int optimizedBubbleSort(int[] A) {
//        boolean changed = false;
//        for (int i = 0; i < A.length; i++) {
//            changed = false;
//            for (int j = 0; j < A.length - i - 1; j++) {
//                if (A[j] > A[j + 1]) {
//                    changed = true;
//                    int temp = A[j];
//                    A[j] = A[j + 1];
//                    A[j + 1] = temp;
//                }
//            }
//            if (!changed) {
//                return i + 1;
//            }
//        }
//        return A.length + 1;
//    }

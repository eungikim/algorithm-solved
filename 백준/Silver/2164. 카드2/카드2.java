import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N == 1 || N == 2) {
            System.out.println(N);
            br.close();
            return;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i <= N; i += 2) {
            queue.add(i);
        }
        if (N % 2 == 1) {
            queue.add(queue.poll());
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
        br.close();
    }
}
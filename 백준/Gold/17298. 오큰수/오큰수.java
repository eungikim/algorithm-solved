import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<Integer> indexStack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int insertA = Integer.parseInt(st.nextToken());
            A[i] = insertA;

            if (i == 0) {
                indexStack.push(i);
            } else {
                while (!indexStack.empty() && A[indexStack.peek()] < insertA) {
                    result[indexStack.pop()] = insertA;
                }
                indexStack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int e: result) {
            sb.append(e).append(' ');
        }
        System.out.println(sb);
        br.close();
    }
}
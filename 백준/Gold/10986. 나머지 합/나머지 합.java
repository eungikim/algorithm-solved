import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefixSum = new long[N]; // 구간합
        long[] sameRemainder = new long[M]; // 구간합의 나머지가 같은 수를 가진 배열
        long result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                prefixSum[i] = Integer.parseInt(st.nextToken());
            } else {
                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            }
            int sumRemainder = (int) (prefixSum[i] % M);
            if (sumRemainder == 0) result++;
            sameRemainder[sumRemainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (sameRemainder[i] >= 2) {
                result += sameRemainder[i] * (sameRemainder[i] - 1) / 2;
            }
        }

        System.out.print(result);
        br.close();
    }
}
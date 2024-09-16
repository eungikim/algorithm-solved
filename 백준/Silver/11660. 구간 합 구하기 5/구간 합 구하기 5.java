import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] prefixSum = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                prefixSum[i][j] = Integer.parseInt(st.nextToken());
                if (i != 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j != 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i != 0 && j != 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int result = prefixSum[x2][y2];
            if (x1 > 0) {
                result -= prefixSum[x1 - 1][y2];
            }
            if (y1 > 0) {
                result -= prefixSum[x2][y1 - 1];
            }
            if (x1 > 0 && y1 > 0) {
                result += prefixSum[x1 - 1][y1 - 1];
            }
            sb.append(result).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}

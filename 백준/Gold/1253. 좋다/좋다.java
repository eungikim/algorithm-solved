import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            br.close();
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] inputNum = new int[N];
        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputNum);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int checkNum = inputNum[i];

            int startIndex = 0;
            int endIndex = N - 1;
            while (startIndex < endIndex) {
                int sum = inputNum[startIndex] + inputNum[endIndex];
                if (sum < checkNum || startIndex == i) {
                    startIndex++;
                }
                else if (sum > checkNum || endIndex == i) {
                    endIndex--;
                }
                else {
                    result++;
                    break;
                }
            }
        }

        System.out.print(result);
        br.close();
    }
}
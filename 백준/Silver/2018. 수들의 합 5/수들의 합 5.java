import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        if (N == 1 || N == 2) {
            System.out.println(1);
            br.close();
            return;
        }

        int startIndex = 1;
        int endIndex = 2;
        int sum = startIndex + endIndex;
        int result = 1;
        while (startIndex < N / 2 + 1) {
            if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                result++;
                sum -= startIndex;
                startIndex++;
            }
        }

        System.out.print(result);
        br.close();
    }
}
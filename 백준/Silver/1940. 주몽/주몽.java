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
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        if (M >= 200000 || N == 1) {
            System.out.print(0);
            br.close();
            return;
        }

        int [] armorPart = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            armorPart[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(armorPart);

        int startIndex = 0;
        int endIndex = N - 1;
        int result = 0;
        while (startIndex < endIndex) {
            int armorPartSum = armorPart[startIndex] + armorPart[endIndex];
            if (armorPartSum > M) {
                endIndex--;
            }
            else if (armorPartSum < M) {
                startIndex++;
            }
            else {
                result++;
                startIndex++;
                endIndex--;
            }
        }

        System.out.print(result);
        br.close();
    }
}

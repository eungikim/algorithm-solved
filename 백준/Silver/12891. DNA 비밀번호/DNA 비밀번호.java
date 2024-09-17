
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dnaArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int checkACnt = Integer.parseInt(st.nextToken());
        int checkCCnt = Integer.parseInt(st.nextToken());
        int checkGCnt = Integer.parseInt(st.nextToken());
        int checkTCnt = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            switch (dnaArr[i]) {
                case 'A':
                    checkACnt--;
                    break;
                case 'C':
                    checkCCnt--;
                    break;
                case 'G':
                    checkGCnt--;
                    break;
                case 'T':
                    checkTCnt--;
                    break;
            }
        }
        int result = 0;

        if ((checkACnt <= 0) && (checkCCnt <= 0) && (checkGCnt <= 0) && (checkTCnt <= 0)) {
            result++;
        }

        for (int i = 1; i + P <= S; i++) {
            switch (dnaArr[i - 1]) {
                case 'A':
                    checkACnt++;
                    break;
                case 'C':
                    checkCCnt++;
                    break;
                case 'G':
                    checkGCnt++;
                    break;
                case 'T':
                    checkTCnt++;
                    break;
            }
            switch (dnaArr[i + P - 1]) {
                case 'A':
                    checkACnt--;
                    break;
                case 'C':
                    checkCCnt--;
                    break;
                case 'G':
                    checkGCnt--;
                    break;
                case 'T':
                    checkTCnt--;
                    break;
            }

            if ((checkACnt <= 0) && (checkCCnt <= 0) && (checkGCnt <= 0) && (checkTCnt <= 0)) {
                result++;
            }
        }

        System.out.print(result);
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int howManyNumber = Integer.parseInt(st.nextToken());
        int howManyQuery = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] windowSum = new int[howManyNumber + 1];
        for (int i = 0; i < howManyNumber; i++) {
            windowSum[i + 1] = windowSum[i] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < howManyQuery; i++) {
            st = new StringTokenizer(br.readLine());
            int queryI = Integer.parseInt(st.nextToken());
            int queryJ = Integer.parseInt(st.nextToken());
            System.out.println(windowSum[queryJ] - windowSum[queryI - 1]);
        }
    }
}
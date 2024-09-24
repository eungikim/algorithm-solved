import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] nArr = new int[N];

        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(nArr);

        StringBuilder sb = new StringBuilder();
        for (int e : nArr) {
            sb.append(e).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
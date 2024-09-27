import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] pArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        insertionSort(pArr);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += pArr[i] * (N - i);
        }

        System.out.println(result);
        br.close();
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int changeIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[changeIndex]) {
                    changeIndex = j;
                    break;
                }
            }
            if (changeIndex != i) {
                int temp = arr[i];
                for (int j = i - 1; j >= changeIndex; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[changeIndex] = temp;
            }
        }
    }
}

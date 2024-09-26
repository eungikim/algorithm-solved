import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nArr = br.readLine().chars().map(operand -> operand - '0').toArray();

        if (nArr.length == 1) {
            System.out.println(nArr[0]);
            br.close();
            return;
        }
        selectionSort(nArr);

        StringBuilder sb = new StringBuilder();
        for (int e : nArr) {
            sb.append(e);
        }

        System.out.println(sb);
        br.close();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            int max = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 내림차순으로 정렬해야하니 최대값과 찾아 교환한다.
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}

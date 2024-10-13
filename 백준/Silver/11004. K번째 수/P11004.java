import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * 책에서 나온대로 quick sort 로 풀었지만 시간 초과.
 * 책의 코드를 넣어도 시간초과로 통과가 안됨. 채점 데이터가 변경되었나봄.
 */
public class P11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        int kthNumber = quickSort(A, 0, A.length - 1, K - 1);
//        System.out.println(Arrays.toString(sortArray));
        System.out.println(kthNumber);
        br.close();
    }

    public static int quickSort(int[] A, int left, int right, int K) {
        if (left <= right) {
            int sortedPivotIndex = sortPartition(A, left, right);

            if (sortedPivotIndex == K) {
                return A[K];
            } else if (sortedPivotIndex > K) {
                return quickSort(A, left, sortedPivotIndex - 1, K);
            } else {
                return quickSort(A, sortedPivotIndex + 1, right, K);
            }
        }
        return -1;
    }

    public static int sortPartition(int[] arr, int left, int right) {
        if (right - left == 0) {
            return left;
        } else if (right - left == 1) {
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            return left;
        } else {
            Random random = new Random();
            int pivotIndex = left + random.nextInt(right - left + 1);
//            int pivotIndex = (right + left) / 2;
            int pivot = arr[pivotIndex];
            // 피벗을 endIndex로 이동하여 파티션 로직을 단순화
            swap(arr, pivotIndex, right);
            pivotIndex = right;
            right--;

            while (left < right) {
                while (pivot <= arr[right] && left < right)
                    right--;
                if (left >= right) break;
                while (pivot >= arr[left] && left < right)
                    left++;
                if (left >= right) break;
                swap(arr, left, right);
            }

            int sortedPivotIndex = pivot > arr[left] ? left + 1 : left;
            swap(arr, sortedPivotIndex, pivotIndex);
            return sortedPivotIndex;
        }
    }


    private static void swap(int[] array, int index1, int index2) {
        if (index1 == index2) return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

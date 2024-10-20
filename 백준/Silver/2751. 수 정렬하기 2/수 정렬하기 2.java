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
        int[] arrN = new int[N];

        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arrN);
        StringBuilder sb = new StringBuilder();
        for (int e : arrN) {
            sb.append(e).append('\n');
        }
        System.out.println(sb);
        br.close();
    }


    // 병합 정렬 메서드
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // 배열의 크기가 1이면 정렬이 완료된 것으로 간주합니다.
        }

        int mid = array.length / 2;

        // 좌측 배열과 우측 배열로 분할
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // 좌측 배열에 값 할당
        System.arraycopy(array, 0, leftArray, 0, mid);

        // 우측 배열에 값 할당
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        // 재귀 호출로 분할된 배열 정렬
        mergeSort(leftArray);
        mergeSort(rightArray);

        // 정렬된 배열 병합
        merge(array, leftArray, rightArray);
    }

    // 병합 메서드
    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, currentIndex = 0;

        // 좌우 배열의 원소를 비교하여 작은 값부터 병합
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[currentIndex++] = leftArray[leftIndex++];
            } else {
                array[currentIndex++] = rightArray[rightIndex++];
            }
        }

        // 좌측 배열에 남은 원소들을 배열에 추가
        while (leftIndex < leftArray.length) {
            array[currentIndex++] = leftArray[leftIndex++];
        }

        // 우측 배열에 남은 원소들을 배열에 추가
        while (rightIndex < rightArray.length) {
            array[currentIndex++] = rightArray[rightIndex++];
        }
    }
}

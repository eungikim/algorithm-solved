import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    
    val insert1 = StringTokenizer(readLine())
    val N = insert1.nextToken().toInt()
    val M = insert1.nextToken().toInt()

    val insert2 = StringTokenizer(readLine())
    // 구간합 계산
    val sumOfIntervals = IntArray(N + 1)
    repeat(N) { i ->
        sumOfIntervals[i+1] = sumOfIntervals[i] + insert2.nextToken().toInt()
    }

    val stringBuilder = StringBuilder()
    // 구간합의 구간 입력과 바로 계산
    repeat(M) {
        val insert3 = StringTokenizer(readLine())
        val startIndex = insert3.nextToken().toInt()
        val endIndex = insert3.nextToken().toInt()
        val result = sumOfIntervals[endIndex] - sumOfIntervals[startIndex - 1]
        stringBuilder.appendLine(result)
    }
    
    print(stringBuilder.toString())
}
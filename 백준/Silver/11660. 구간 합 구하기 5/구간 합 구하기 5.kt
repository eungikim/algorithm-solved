import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val insert1 = StringTokenizer(readLine())
    val N = insert1.nextToken().toInt()
    val M = insert1.nextToken().toInt()

    val sumOfIntervals = Array(N) { LongArray(N) }
    repeat(N) { i ->
        val insert2 = StringTokenizer(readLine())
        repeat(N) { j ->
            if (i == 0 && j == 0) {
                sumOfIntervals[i][j] = insert2.nextToken().toLong()
            } else if (i == 0) {
                sumOfIntervals[i][j] = sumOfIntervals[i][j - 1] + insert2.nextToken().toLong()
            } else if (j == 0) {
                sumOfIntervals[i][j] = sumOfIntervals[i - 1][j] + insert2.nextToken().toLong()
            } else {
                sumOfIntervals[i][j] =
                    sumOfIntervals[i - 1][j] + sumOfIntervals[i][j - 1] - sumOfIntervals[i - 1][j - 1] + insert2.nextToken().toLong()
            }
        }
    }

    val stringBuilder = StringBuilder()
    repeat(M) {
        val insert3 = StringTokenizer(readLine())
        val x1 = insert3.nextToken().toInt() - 1
        val y1 = insert3.nextToken().toInt() - 1
        val x2 = insert3.nextToken().toInt() - 1
        val y2 = insert3.nextToken().toInt() - 1

        val T = sumOfIntervals[x2][y2]
        val S1 = if (x1 - 1 >= 0) sumOfIntervals[x1 - 1][y2] else 0
        val S2 = if (y1 - 1 >= 0) sumOfIntervals[x2][y1 - 1] else 0
        val S3 = if (x1 - 1 >= 0 && y1 - 1 >= 0) sumOfIntervals[x1 - 1][y1 - 1] else 0
      stringBuilder.appendLine(T - S1 - S2 + S3)
    }

    print(stringBuilder.toString())
}
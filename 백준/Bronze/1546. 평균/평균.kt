import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val countOfClass = readLine().toInt()
    val classScore = readLine().split(' ').map { it.toInt() }

    var max = 0
    var sum = 0.0
    classScore.forEach {
        max = kotlin.math.max(max, it)
        sum += it
    }

    val result = sum / max * 100 / countOfClass

    print(result)
}
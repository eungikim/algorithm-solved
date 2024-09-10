import java.util.Scanner
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    val D = nextInt().toDouble()
    val H = nextInt().toDouble()
    val W = nextInt().toDouble()

    val ratio = Math.sqrt((D.pow(2.0)) / (H.pow(2.0) + W.pow(2.0)))

    val height = ratio * H
    val width = ratio * W
    println("${height.toInt()} ${width.toInt()}")
}
import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val countOfNumber = nextInt()
    val numberString = next()
    val result = numberString.chars().map { it - 48 }.sum()
    println(result)
}
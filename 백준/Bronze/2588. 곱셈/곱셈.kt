import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val first = nextInt()
    val second = nextInt()

    val 두번째숫자1의자리 = second % 10
    val 두번째숫자10의자리 = (second - 두번째숫자1의자리) % 100
    val 두번째숫자100의자리 = (second - 두번째숫자1의자리 - 두번째숫자10의자리) % 1000

    println(first * 두번째숫자1의자리)
    println(first * (두번째숫자10의자리 / 10))
    println(first * (두번째숫자100의자리 / 100))
    println(first * second)
}

fun main() {
    // 첫째 줄에 성우의 현재 위치와 민건이의 집까지의 거리 L(1 ≤ L ≤ 1,000,000)가 주어진다.
    val input = readLine()?.toInt() ?: throw RuntimeException("입력이 다름")

    val findTime = input / 5
    val additional = if (input % 5 == 0) 0 else 1

    println(findTime + additional)
}
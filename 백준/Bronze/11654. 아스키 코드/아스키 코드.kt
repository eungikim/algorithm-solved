fun main() {
    // 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
    val input: Char? = readLine()?.get(0)

    println("${input?.code}")
}
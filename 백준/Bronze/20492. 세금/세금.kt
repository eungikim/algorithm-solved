
fun main() {
    // 상금의 금액을 나타내는 하나의 정수 N 이 주어진다.
    val input = readLine()?.toInt() ?: 0

    println("${excludeTax22(input)} ${excludeTax22WithExpenses(input)}")
}

fun excludeTax22(prize: Int): Int {
    val tax = prize.toFloat() * 0.22
    return (prize - tax).toInt()
}

fun excludeTax22WithExpenses(prize: Int): Int {
    val expenses = prize.toFloat() * 0.8
    val withoutExpenses = prize - expenses
    return (expenses + excludeTax22(withoutExpenses.toInt())).toInt()
}
fun main() {
    val input = readLine()?.split(' ')
    input?.let {
        if (it.size >= 2) println(it[0].toDouble() / it[1].toDouble())
    }
}
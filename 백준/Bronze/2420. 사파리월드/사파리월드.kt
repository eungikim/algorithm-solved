fun main() {
    val input = readLine()?.split(' ')?.map { it.toLong() }
    input?.let {
        if (it.size >= 2) println(Math.abs(it[0] - it[1]))
    }
}
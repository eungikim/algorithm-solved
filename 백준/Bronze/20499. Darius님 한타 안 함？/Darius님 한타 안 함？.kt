fun main() {
    val (kill, death, assi) = readLine()?.split('/')?.map { it.toInt() }!!
    val result = if ((kill + assi) < death || death == 0) "hasu" else "gosu"
    println(result)
}

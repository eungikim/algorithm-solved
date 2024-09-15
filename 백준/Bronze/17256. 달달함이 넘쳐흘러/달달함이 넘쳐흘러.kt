fun main() {
    val input1 = readLine()?.split(" ")?.map { it.toInt() }!!
    val input2 = readLine()?.split(" ")?.map { it.toInt() }!!
    val cakeA = Cake(input1)
    val cakeC = Cake(input2)

    val cakeB = cakeA reversCake cakeC
    println(cakeB)
}

data class Cake(val x: Int, val y: Int, val z: Int) {

    constructor(array: List<Int>): this(array[0], array[1], array[2])
    // 🍰
    infix fun cake(other: Cake): Cake {
        return Cake(z + other.x, y * other.y, x + other.z)
    }

    infix fun reversCake(result: Cake): Cake {
        return Cake(result.x - z, result.y / y, result.z - x)
    }

    override fun toString(): String {
        return "$x $y $z"
    }
}
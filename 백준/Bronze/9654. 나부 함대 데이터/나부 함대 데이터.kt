fun main() {
    val format = "%-15s%-15s%-11s%-10s"
    val shipName = arrayOf("N2 Bomber", "J-Type 327", "NX Cruiser", "N1 Starfighter", "Royal Cruiser")
    val class_ = arrayOf("Heavy Fighter", "Light Combat", "Medium Fighter", "Medium Fighter", "Light Combat")
    val deployment = arrayOf("Limited", "Unlimited", "Limited", "Unlimited", "Limited")
    val inService = arrayOf(21, 1, 18, 25, 4)
    println(String.format(format, "SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE"))
    for (i in 0..4) {
        println(String.format(format, shipName[i], class_[i], deployment[i], inService[i]))
    }
}
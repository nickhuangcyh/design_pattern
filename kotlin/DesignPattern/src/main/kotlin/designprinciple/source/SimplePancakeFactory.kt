package designprinciple.source

object SimplePancakeFactory {
    fun createPancake(type: String): Pancake {
        return when (type) {
            "classic" -> ClassicPancake()
            "blueberry" -> BlueberryPancake()
            "banana" -> BananaPancake()
//        "chocolate chip" -> ChocolateChipPancake()
            else -> ClassicPancake()
        }
    }
}
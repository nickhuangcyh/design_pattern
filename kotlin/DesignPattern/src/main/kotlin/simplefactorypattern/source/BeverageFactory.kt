package simplefactorypattern.source

object BeverageFactory {
    fun createBeverage(beverageName: String): Beverage? {
        return when (beverageName) {
            "black tea" -> BlackTea()
            "green tea" -> GreenTea()
            else -> null
        }
    }
}
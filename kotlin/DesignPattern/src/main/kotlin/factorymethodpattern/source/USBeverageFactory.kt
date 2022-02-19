package factorymethodpattern.source

class USBeverageFactory: BeverageFactory {
    override fun createBeverage(beverageName: String): Beverage? {
        return when (beverageName) {
            "black tea" -> CeylonBlackTea()
            "green tea" -> GyokuroGreenTea()
            else -> null
        }
    }
}
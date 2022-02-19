package factorymethodpattern.source

class EUBeverageFactory: BeverageFactory {
    override fun createBeverage(beverageName: String): Beverage? {
        return when (beverageName) {
            "black tea" -> EarlGreyBlackTea()
            "green tea" -> SenchaGreenTea()
            else -> null
        }
    }
}
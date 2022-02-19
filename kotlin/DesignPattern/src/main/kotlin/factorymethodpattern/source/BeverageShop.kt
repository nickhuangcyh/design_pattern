package factorymethodpattern.source

class BeverageShop(private val factory: BeverageFactory) {

    fun order(beverageName: String): Beverage? {
        val beverage: Beverage? = factory.createBeverage(beverageName)

        beverage?.addSuger(5)
        beverage?.addIce(5)
        beverage?.shake()
        beverage?.packageUp()

        return  beverage
    }
}
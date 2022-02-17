package simplefactorypattern.source

class BeverageShop {
    fun order(beverageName: String): Beverage? {
        val beverage: Beverage? = BeverageFactory.createBeverage(beverageName)

        beverage?.addSuger(5)
        beverage?.addIce(5)
        beverage?.shake()
        beverage?.packageUp()

        return  beverage
    }
}
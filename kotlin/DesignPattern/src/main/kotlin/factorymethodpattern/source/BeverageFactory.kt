package factorymethodpattern.source

interface BeverageFactory {
    fun createBeverage(beverageName: String): Beverage?
}
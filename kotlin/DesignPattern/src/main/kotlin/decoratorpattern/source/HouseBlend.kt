package decoratorpattern.source

class HouseBlend : Beverage {
    override val description = "House Blend Coffee"
    override fun cost() = 0.89
}
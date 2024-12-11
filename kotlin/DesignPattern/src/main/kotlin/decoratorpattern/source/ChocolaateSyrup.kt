package decoratorpattern.source

class ChocolateSyrup(beverage: Beverage) : CondimentDecorator(beverage) {
    override val description = "${beverage.description}, Chocolate Syrup"
    override fun cost() = beverage.cost() + 0.5
}
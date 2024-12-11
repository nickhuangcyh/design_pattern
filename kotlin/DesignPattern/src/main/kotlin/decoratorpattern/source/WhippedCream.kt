package decoratorpattern.source

class WhippedCream(beverage: Beverage) : CondimentDecorator(beverage) {
    override val description = "${beverage.description}, Whipped Cream"
    override fun cost() = beverage.cost() + 0.4
}
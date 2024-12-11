package decoratorpattern.source

class Milk(beverage: Beverage) : CondimentDecorator(beverage) {
    override val description = "${beverage.description}, Milk"
    override fun cost() = beverage.cost() + 0.3
}
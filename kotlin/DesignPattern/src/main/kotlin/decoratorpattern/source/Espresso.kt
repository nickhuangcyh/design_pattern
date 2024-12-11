package decoratorpattern.source

class Espresso : Beverage {
    override val description = "Espresso"
    override fun cost() = 1.99
}
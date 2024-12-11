package decoratorpattern.source

abstract class CondimentDecorator(protected val beverage: Beverage) : Beverage {
    override abstract val description: String
}
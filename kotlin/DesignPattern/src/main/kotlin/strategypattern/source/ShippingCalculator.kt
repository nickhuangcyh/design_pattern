package strategypattern.source

class ShippingCalculator(private var strategy: ShippingStrategy) {

    fun setStrategy(strategy: ShippingStrategy) {
        this.strategy = strategy
    }

    fun calculateCost(weight: Double, region: String): Double {
        return strategy.calculateShippingCost(weight, region)
    }
}
package strategypattern.source

interface ShippingStrategy {
    fun calculateShippingCost(weight: Double, region: String): Double
}
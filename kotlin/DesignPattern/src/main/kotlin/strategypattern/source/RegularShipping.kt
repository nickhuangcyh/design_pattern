package strategypattern.source

class RegularShipping : ShippingStrategy {
    override fun calculateShippingCost(weight: Double, region: String): Double {
        return 50.0 // 固定運費
    }
}
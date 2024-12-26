package strategypattern.source

class ExpressShipping : ShippingStrategy {
    override fun calculateShippingCost(weight: Double, region: String): Double {
        return weight * 10 // 每公斤 10 元
    }
}
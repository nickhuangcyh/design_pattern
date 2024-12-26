package strategypattern

import strategypattern.source.ExpressShipping
import strategypattern.source.InternationalShipping
import strategypattern.source.RegularShipping
import strategypattern.source.ShippingCalculator

fun main() {
    val calculator = ShippingCalculator(RegularShipping())

    println("一般配送運費: ${calculator.calculateCost(5.0, "Asia")} 元") // 固定 50 元

    calculator.setStrategy(ExpressShipping())
    println("快速配送運費: ${calculator.calculateCost(5.0, "Asia")} 元") // 5.0 * 10 = 50 元

    calculator.setStrategy(InternationalShipping())
    println("國際配送運費 (Asia): ${calculator.calculateCost(5.0, "Asia")} 元") // 5.0 * 15 = 75 元
}
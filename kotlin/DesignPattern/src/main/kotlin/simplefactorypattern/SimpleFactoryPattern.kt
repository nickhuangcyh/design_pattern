package simplefactorypattern

import simplefactorypattern.source.BeverageFactory
import simplefactorypattern.source.BeverageShop

fun main() {
    val beverage = BeverageShop(BeverageFactory())
    val blackTea = beverage.order("black tea")
    val greenTea = beverage.order("green tea")
}
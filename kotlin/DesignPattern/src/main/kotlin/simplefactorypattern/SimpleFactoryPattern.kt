package simplefactorypattern

import simplefactorypattern.source.BeverageShop

fun main() {
    val beverage = BeverageShop()
    val blackTea = beverage.order("black tea")
    val greenTea = beverage.order("green tea")
}
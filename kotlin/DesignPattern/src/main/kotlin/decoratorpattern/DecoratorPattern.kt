package decoratorpattern

import decoratorpattern.source.*

fun main() {
    // Make an Espresso
    val espresso = Espresso()
    println("${espresso.description}: $${espresso.cost()}")

    // Make an Espresso with Milk、Chocolate Syrup and Whipped Cream
    val customBeverage = WhippedCream(
        ChocolateSyrup(
            Milk(Espresso())
        )
    )
    println("${customBeverage.description}: $${customBeverage.cost()}")

    // Make an HouseBlend with Milk and double Whipped Cream
    val layeredBeverage = WhippedCream(
        WhippedCream(
            Milk(HouseBlend())
        )
    )
    println("${layeredBeverage.description}: $${layeredBeverage.cost()}")
}
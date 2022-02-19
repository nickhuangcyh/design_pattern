package factorymethodpattern

import factorymethodpattern.source.BeverageShop
import factorymethodpattern.source.EUBeverageFactory
import factorymethodpattern.source.USBeverageFactory

fun main() {
    val usBeverageShop = BeverageShop(USBeverageFactory())
    val usBlackTea = usBeverageShop.order("black tea")
    val usGreenTea = usBeverageShop.order("green tea")

    val euBeverageShop = BeverageShop(EUBeverageFactory())
    val euBlackTea = euBeverageShop.order("black tea")
    val euGreenTea = euBeverageShop.order("green tea")
}
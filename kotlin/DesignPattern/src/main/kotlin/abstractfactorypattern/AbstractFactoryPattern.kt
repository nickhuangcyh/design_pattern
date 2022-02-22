package abstractfactorypattern

import abstractfactorypattern.source.EUBeverageFactory
import abstractfactorypattern.source.USBeverageFactory

fun main() {
    val usBeverageFactory = USBeverageFactory()
    val usBlackTea = usBeverageFactory.createBlackTea()
    val usGreenTea = usBeverageFactory.createGreenTea()

    println("usBlackTea is $usBlackTea")
    println("usGreenTea is $usGreenTea")

    val euBeverageFactory = EUBeverageFactory()
    val euBlackTea = euBeverageFactory.createBlackTea()
    val euGreenTea = euBeverageFactory.createGreenTea()

    println("euBlackTea is $euBlackTea")
    println("euGreenTea is $euGreenTea")
}
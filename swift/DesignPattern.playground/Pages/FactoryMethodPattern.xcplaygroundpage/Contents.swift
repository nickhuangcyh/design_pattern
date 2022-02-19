//: [Previous](@previous)

import Foundation

let usBeverageShop = BeverageShop(factory: USBeverageFactory())
let usBlackTea = usBeverageShop.order(beverageName: "black tea")
let usGreenTea = usBeverageShop.order(beverageName: "green tea")

let euBeverageShop = BeverageShop(factory: EUBeverageFactory())
let euBlackTea = euBeverageShop.order(beverageName: "black tea")
let euGreenTea = euBeverageShop.order(beverageName: "green tea")

//: [Next](@next)

//: [Previous](@previous)

import Foundation

/*:
 ## Simple Factory Pattern 簡單工廠模式
 */

let beverageShop = BeverageShop(factory: BeverageFactory())
let blackTea = beverageShop.order(beverageName: "black tea")
let greenTea = beverageShop.order(beverageName: "green tea")

//: [Next](@next)

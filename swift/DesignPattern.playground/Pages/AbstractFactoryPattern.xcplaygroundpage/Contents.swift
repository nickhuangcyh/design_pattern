//: [Previous](@previous)

import Foundation

let usBeverageFactory = USBeverageFactory()
let usBlackTea = usBeverageFactory.createBlackTea()
let usGreenTea = usBeverageFactory.createGreenTea()

print("usBlackTea is \(usBlackTea)")
print("usGreenTea is \(usGreenTea)")

let euBeverageFactory = EUBeverageFactory()
let euBlackTea = euBeverageFactory.createBlackTea()
let euGreenTea = euBeverageFactory.createGreenTea()

print("euBlackTea is \(euBlackTea)")
print("euGreenTea is \(euGreenTea)")

//: [Next](@next)

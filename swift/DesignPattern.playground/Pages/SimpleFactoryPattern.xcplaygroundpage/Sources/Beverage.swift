import Foundation

public protocol Beverage {
    func addSuger(level: Int)
    func addIce(level: Int)
    func shake()
    func packageUp()
}

public extension Beverage {
    func addSuger(level: Int) {
        print("[\(self)] addSuger \(level)")
    }
    
    func addIce(level: Int) {
        print("[\(self)] addIce \(level)")
    }
    
    func shake() {
        print("[\(self)] shake")
    }
    
    func packageUp() {
        print("[\(self)] packageUp")
    }
}

import Foundation

public class BeverageShop {
    public init() {}
    
    public func order(beverageName: String) -> Beverage? {
        let beverage: Beverage? = BeverageFactory.createBeverage(beverageName: beverageName)
        
        beverage?.addSuger(level: 5)
        beverage?.addIce(level: 5)
        beverage?.shake()
        beverage?.packageUp()
        
        return beverage
    }
}

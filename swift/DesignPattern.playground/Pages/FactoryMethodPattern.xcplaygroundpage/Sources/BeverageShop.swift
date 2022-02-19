import Foundation

public class BeverageShop {
    
    private let factory: BeverageFactory
    
    public init(factory: BeverageFactory) {
        self.factory = factory
    }
    
    public func order(beverageName: String) -> Beverage? {
        let beverage: Beverage? = factory.createBeverage(beverageName: beverageName)
        
        beverage?.addSuger(level: 5)
        beverage?.addIce(level: 5)
        beverage?.shake()
        beverage?.packageUp()
        
        return beverage
    }
}

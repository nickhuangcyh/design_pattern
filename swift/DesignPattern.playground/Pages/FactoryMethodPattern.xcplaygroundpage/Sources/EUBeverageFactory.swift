import Foundation

open class EUBeverageFactory: BeverageFactory {
    
    public init() {}
    
    public func createBeverage(beverageName: String) -> Beverage? {
        var beverage: Beverage?
        
        switch beverageName {
        case "black tea":
            beverage = EarlGreyBlackTea()
        case "green tea":
            beverage = SenchaGreenTea()
        default:
            break
        }
        
        return beverage
    }
}

import Foundation

open class USBeverageFactory: BeverageFactory {
    
    public init() {}
    
    public func createBeverage(beverageName: String) -> Beverage? {
        var beverage: Beverage?
        
        switch beverageName {
        case "black tea":
            beverage = CeylonBlackTea()
        case "green tea":
            beverage = GyokuroGreenTea()
        default:
            break
        }
        
        return beverage
    }
}

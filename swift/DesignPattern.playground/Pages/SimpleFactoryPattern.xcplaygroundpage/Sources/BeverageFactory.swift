import Foundation

open class BeverageFactory {
    public init() {}
    
    func createBeverage(beverageName: String) -> Beverage? {
        var beverage: Beverage?
        
        switch beverageName {
        case "black tea":
            beverage = BlackTea()
        case "green tea":
            beverage = GreenTea()
        default:
            break
        }
        
        return beverage
    }
}

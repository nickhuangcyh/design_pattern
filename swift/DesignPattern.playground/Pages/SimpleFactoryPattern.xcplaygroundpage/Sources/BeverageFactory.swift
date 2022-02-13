import Foundation

class BeverageFactory {
    class func createBeverage(beverageName: String) -> Beverage? {
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

import Foundation

public protocol BeverageFactory {
    func createBeverage(beverageName: String) -> Beverage?
}

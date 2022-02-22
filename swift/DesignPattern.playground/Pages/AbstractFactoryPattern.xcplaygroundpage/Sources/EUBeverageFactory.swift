import Foundation

open class EUBeverageFactory: BeverageFactory {
    
    public init() {}
    
    public func createBlackTea() -> BlackTea? {
        return EarlGreyBlackTea()
    }
    
    public func createGreenTea() -> GreenTea? {
        return SenchaGreenTea()
    }
}



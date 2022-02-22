import Foundation

open class USBeverageFactory: BeverageFactory {
    
    public init() {}
    
    public func createBlackTea() -> BlackTea? {
        return CeylonBlackTea()
    }
    
    public func createGreenTea() -> GreenTea? {
        return GyokuroGreenTea()
    }
}

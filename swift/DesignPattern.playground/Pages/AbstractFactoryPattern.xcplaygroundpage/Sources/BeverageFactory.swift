import Foundation

public protocol BeverageFactory {
    func createBlackTea() -> BlackTea?
    func createGreenTea() -> GreenTea?
}

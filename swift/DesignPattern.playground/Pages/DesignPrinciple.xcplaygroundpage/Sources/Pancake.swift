import Foundation

public protocol Pancake {
    func cook()
    func plate()
    func addButter()
}

extension Pancake {
    public func cook() {
        print("cook")
    }
    public   
    func plate() {
        print("plate")
    }
    
    public func addButter() {
        print("addButter")
    }
}

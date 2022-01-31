import Foundation

public class SimplePancakeFactory {
    public class func createPancake(type: String) -> Pancake? {
        var pancake: Pancake?
        
        // Code that is varying
        switch type {
        case "classic":
            pancake = ClassicPancake()
        case "blueberry":
            pancake = BlueberryPancake()
        case "banana":
            pancake = BananaPancake()
        //    case "chocolate chip":
        //        pancake = ChocolateChipPancake()
        default:
            pancake = ClassicPancake()
        }
        
        return pancake
    }
}

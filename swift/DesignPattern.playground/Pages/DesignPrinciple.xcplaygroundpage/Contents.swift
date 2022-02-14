//: [Previous](@previous)

import Foundation

/*:
 ## Encapsulate What Varies 封裝變化
 * 識別程式中會常因需求改變而需改變的部分，將其與不變的部分區隔開來，將會變化的部分封裝起來。
 */

/*:
 ### Before
 */

func orderPancake(type: String) {
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
    
    // Important code that does not vary
    pancake?.cook()
    pancake?.plate()
    pancake?.addButter()
}

/*:
 ### After
 */
func orderPancakeWithFactory(type: String) {
    let pancake = SimplePancakeFactory.createPancake(type: type)
    
    // Important code that does not vary
    pancake?.cook()
    pancake?.plate()
    pancake?.addButter()
}

/*:
 ## SOLID
 * 物件導向程式設計基本五大原則
 */

/*:
 ### Extension
 */
extension String {
    func isContainsSpecialChars(_ specialChars: String = "~,:;\\\"|<>’=!@#$%^&*()-/") -> Bool {
        let characterSet = CharacterSet(charactersIn: specialChars)
        let range = self.rangeOfCharacter(from: characterSet)
        return range != nil
    }
}

/*:
 ## Single Responsibility Principle (SRP) 單一職責原則
 * 物件應該僅具有一種單一功能，應只會有一個理由去改變此物件
 */
/*:
 ### Before
 */
class LoginViewController {
    func loginToServer(account: String, password: String, callback: Result<String, Error>) {
//        Alamofire... { callback() }
//        Volley... { callback() }
    }
    
    func saveToDB(account: String, password: String) {
        // sql.save()...
    }
    
    func deleteFromDB(account: String) {
        // sql.delete()
    }
}
/*:
 ### After
 */
class ServerApiRequestService {
    func login(account: String, password: String, callback: Result<String, Error>) {
//        Alamofire... { callback() }
//        Volley... { callback() }
    }
}

class DBService {
    func save(account: String, password: String) {
//        sql.save()
    }
    
    func delete(account: String) {
//        sql.delete()
    }
}

class LoginViewControllerSRP {
    var apiRequestService: ServerApiRequestService? = nil
    var dbService: DBService? = nil
    
    func loginToServer(account: String, password: String, callback: Result<String, Error>) {
        apiRequestService?.login(account: account, password: password, callback: callback)
    }
    
    func saveToDB(account: String, password: String) {
        dbService?.save(account: account, password: password)
    }
    
    func deleteFromDB(account: String) {
        dbService?.delete(account: account)
    }
}

/*:
 
 * 有些文章會說 save, delete function 也須拆開在不同class(DeleteDBService, SaveDBService)處理, 因為 save. delete 是不同職責修改項目, 不應動到另一個class, 但我認為這樣 Over Design 反而不好維護, 拆分職責應適當不過度
 
 */

/*:
 
 ## Open Closed Principle (OCP) 開放封閉原則
 
 * 對於擴充開放，對於修改封閉
 
 */

/*:
 ### Setup
 */
enum ValidatorType {
    case username
    case password
}

enum ValidationError: Error, Equatable {
    case isEmpty(errorMessage: String)
    case containsSpecialChar(errorMessage: String)
    
    static func == (lhs: Self, rhs: Self) -> Bool {
        switch (lhs, rhs) {
        case (.isEmpty(_), .isEmpty(_)):
            return true
        case (.containsSpecialChar(_), .containsSpecialChar(_)):
            return true
        default:
            return false
        }
    }
}
/*:
 ### Before
 */
class Validator {
    func validated(_ value: String, validatorType: ValidatorType) throws -> String {
        switch validatorType {
        case .username:
            guard !value.isEmpty else {
                throw ValidationError.isEmpty(errorMessage: "isEmpty")
            }
            guard !value.isContainsSpecialChars() else {
                throw ValidationError.containsSpecialChar(errorMessage: "containsSpecialChar")
            }
        case .password:
            guard !value.isEmpty else {
                throw ValidationError.isEmpty(errorMessage: "isEmpty")
            }
        }
        return value
    }
}

/*:
 ### After
 */
protocol ValidatorConvertible {
    func validated(_ value: String) throws -> String
}

class UserNameValidator: ValidatorConvertible {
    
    func validated(_ value: String) throws -> String {
        guard !value.isEmpty else {
            throw ValidationError.isEmpty(errorMessage: "isEmpty")
        }
        guard !value.isContainsSpecialChars() else {
            throw ValidationError.containsSpecialChar(errorMessage: "containsSpecialChar")
        }
        return value
    }
}

class PasswordValidator: ValidatorConvertible {
    
    func validated(_ value: String) throws -> String {
        guard !value.isEmpty else {
            throw ValidationError.isEmpty(errorMessage: "isEmpty")
        }
        return value
    }
}

/*:
 
 ## Liskov Substitution Principle (LSP) 里氏替換原則
 
 * 程式中的物件應該是可以在不改變程式正確性的前提下被它的子類所替換的
 
 */

class Rectangle {
    var height: Int
    var width: Int
    
    init(height: Int, width: Int) {
        self.height = height
        self.width = width
    }
    
    func getArea() -> String {
        return "\(height * width)"
    }
}

class Square: Rectangle {
    override func getArea() -> String {
        if height != width {
            return "長寬需一致"
        } else {
            return super.getArea()
        }
    }
}

let rectangle = Rectangle(height: 2, width: 3)
print("\(rectangle.getArea())")
let square = Square(height: 2, width: 3)
print("\(square.getArea())")

/*:
 * 增加程式碼的健全度，在使用不同的子類別的時候，可以大幅度的保證彼此之間的相容性。只要父類別可以使用，基本上子類別也可以使用
 * 子類別如果要新增功能，獨立在父類別的功能之外，才不會在搬移到其他子類別的時候發生奇怪的問題，也可以將功能切分乾淨，區分職責
 */

/*:
 
 ## Interface Segregation Principle (ISP) 介面隔離原則
 
 * 多個特定客戶端介面要好於一個寬泛用途的介面
 
 */

/*:
 ### Before
 */
protocol Car {
    func startEngine()
    func stopEngine()
    func enableDebugMode()
}

class Driver: Car {
    func startEngine() {
        print("start engine")
    }
    
    func stopEngine() {
        print("stop engine")
    }
    
    func enableDebugMode() {
        print("enable debug mode")
    }
}

class Engineer: Car {
    func startEngine() {
        print("start engine")
    }
    
    func stopEngine() {
        print("stop engine")
    }
    
    func enableDebugMode() {
        print("enable debug mode")
    }
}

/*:
 工程師可以開啟 DebugMode, 但駕駛使用者不應該可以開啟 DebugMode
 */

/*:
 ### After
 */

protocol Car1 {
    func startEngine()
    func stopEngine()
}

protocol Debuggable {
    func enableDebugMode()
}

class Driver1: Car1 {
    func startEngine() {
        print("start engine")
    }
    
    func stopEngine() {
        print("stop engine")
    }
}

class Engineer1: Car1, Debuggable {
    func startEngine() {
        print("start engine")
    }
    
    func stopEngine() {
        print("stop engine")
    }
    
    func enableDebugMode() {
        print("enable debug mode")
    }
}

/*:
 
 ## Dependency Inversion Principle (DIP) 依賴反向原則
 
 * 依賴於抽象而不是一個實例
 
 */

/*:
 ### Setup
 */

class Room {
    var no: Int
    var device: [String]
    
    init(no: Int, device: [String]) {
        self.no = no
        self.device = device
    }
}

/*:
 ### Before
 */

class SQLiteService {
    func saveRoom(room: Room) {
        print("SQLiteService save")
    }
    
    func deleteRoom(no: Int) {
        print("SQLiteService delete")
    }
}

class RoomViewController {
    var sqlDBService: SQLiteService? = nil
    
    init(sqlDBService: SQLiteService) {
        sqlDBService
    }
    
    func saveRoomToDB(room: Room) {
        sqlDBService?.saveRoom(room: room)
    }
    
    func deleteRoomFromDB(no: Int) {
        sqlDBService?.deleteRoom(no: no)
    }
}

let roomVC = RoomViewController(sqlDBService: SQLiteService())
let room = Room(no: 1, device: ["IPCam", "VDP"])
roomVC.saveRoomToDB(room: room)
roomVC.deleteRoomFromDB(no: room.no)

/*:
 如果今天 SQLite 因某些問題(速度過慢等等...)因素，導致我們必須換成 CoreData 或其他 Database 呢?
 */

/*:
 ### After
 */
protocol DataBaseService {
    func saveRoom(room: Room)
    func deleteRoom(no: Int)
}

class SQLiteDBService: DataBaseService {
    func saveRoom(room: Room) {
        print("SQLiteDBService save")
    }
    
    func deleteRoom(no: Int) {
        print("SQLiteDBService delete")
    }
}

class CoreDataDBService: DataBaseService {
    func saveRoom(room: Room) {
        print("CoreDataDBService save")
    }
    
    func deleteRoom(no: Int) {
        print("CoreDataDBService delete")
    }
}

class MySQLDBService: DataBaseService {
    func saveRoom(room: Room) {
        print("MySQLDBService save")
    }
    
    func deleteRoom(no: Int) {
        print("MySQLDBService delete")
    }
}

class Room2ViewController {
    var databaseService: DataBaseService? = nil
    
    init(databaseService: DataBaseService) {
        self.databaseService = databaseService
    }
    
    func saveRoomToDB(room: Room) {
        databaseService?.saveRoom(room: room)
    }
    
    func deleteRoomFromDB(no: Int) {
        databaseService?.deleteRoom(no: no)
    }
}

let sqliteDB = SQLiteDBService()
let coreDataDB = CoreDataDBService()
let mysqlDB = MySQLDBService()

let room2VC = Room2ViewController(databaseService: sqliteDB)
let room2 = Room(no: 2, device: ["IPCam", "VDP"])

// sql
room2VC.saveRoomToDB(room: room2)
room2VC.deleteRoomFromDB(no: room2.no)

// coredata
room2VC.databaseService = coreDataDB
room2VC.saveRoomToDB(room: room2)
room2VC.deleteRoomFromDB(no: room2.no)

// mysql
room2VC.databaseService = mysqlDB
room2VC.saveRoomToDB(room: room2)
room2VC.deleteRoomFromDB(no: room2.no)

/*:
 抽象 - interface, protocol, abstract class
 * 依賴於抽象可以使我們的程式碼更加有彈性, 也更好抽換依賴物件
 * 養成多寫一層抽象成能使代碼更好維護、測試
 * 抽象層能使我們非常容易的製作假物件快速測試程式邏輯
 */



//: [Next](@next)

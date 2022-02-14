package designprinciple

import designprinciple.source.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.jvm.Throws

/*:
 ## Encapsulate What Varies 封裝變化
 * 識別程式中會常因需求改變而需改變的部分，將其與不變的部分區隔開來，將會變化的部分封裝起來。
 */

/*:
 ### Before
 */

fun orderPancake(type: String) {

    // Code that is varying
    val pancake: Pancake = when (type) {
        "classic" -> ClassicPancake()
        "blueberry" -> BlueberryPancake()
        "banana" -> BananaPancake()
//        "chocolate chip" -> ChocolateChipPancake()
        else -> ClassicPancake()
    }

    // Important code that does not vary
    pancake.cook()
    pancake.plate()
    pancake.addButter()
}

/*:
 ### After
 */

fun orderPancakeWithFactory(type: String) {
    val pancake = SimplePancakeFactory.createPancake(type)

    // Important code that does not vary
    pancake.cook()
    pancake.plate()
    pancake.addButter()
}

/*:
 ## SOLID
 * 物件導向程式設計基本五大原則
 */

/*:
 ### Extension
 */

fun String.isContainsSpecialChars(): Boolean {
    val pattern: Pattern = Pattern.compile("[^a-zA-Z0-9]")
    val matcher: Matcher = pattern.matcher(this)
    val isStringContainsSpecialCharacter: Boolean = matcher.find()
    return matcher.find()
}

/*:
 ## Single Responsibility Principle (SRP) 單一職責原則
 * 物件應該僅具有一種單一功能，應只會有一個理由去改變此物件
 */
/*:
 ### Before
 */

class LoginActivity {
    fun loginToServer(account: String, password: String, callback:  model.Result<String, Error>) {
//        Alamofire... { callback() }
//        Volley... { callback() }
    }

    fun saveToDB(account: String, password: String) {
        // sql.save()...
    }

    fun deleteFromDB(account: String) {
        // sql.delete()
    }
}

/*:
 ### After
 */
class ServerApiRequestService {
    fun login(account: String, password: String, callback: model.Result<String, Error>) {
//        Alamofire... { callback() }
//        Volley... { callback() }
    }
}

class DBService {
    fun save(account: String, password: String) {
//        sql.save()
    }

    fun delete(account: String) {
//        sql.delete()
    }
}

class LoginActivitySRP {
    var apiRequestService: ServerApiRequestService? = null
    var dbService: DBService? = null

    fun loginToServer(account: String, password: String, callback: model.Result<String, Error>) {
        apiRequestService?.login(account, password, callback)
    }

    fun saveToDB(account: String, password: String) {
        dbService?.save(account, password)
    }

    fun deleteFromDB(account: String) {
        dbService?.delete(account)
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

enum class ValidatorType {
    Username,
    Password;
}

sealed class ValidationException: Exception() {
    class IsEmpty(val errorMessage: String): ValidationException()
    class ContainsSpecialChar(val errorMessage: String): ValidationException()

    override fun equals(other: Any?): Boolean {
        return when {
            this is IsEmpty && other is IsEmpty -> true
            this is ContainsSpecialChar && other is ContainsSpecialChar -> true
            else -> false
        }
    }
}

/*:
 ### Before
 */
class Validator {
    @Throws(ValidationException::class)
    fun validated(value: String, validatorType: ValidatorType): String {
        when (validatorType) {
            ValidatorType.Username -> when {
                value.isEmpty() -> throw ValidationException.IsEmpty("isEmpty")
                value.isContainsSpecialChars() -> throw ValidationException.ContainsSpecialChar("containsSpecialChar")
            }
            ValidatorType.Password -> when {
                value.isEmpty() -> throw ValidationException.IsEmpty("isEmpty")
            }
        }
        return value
    }
}

/*:
 ### After
 */
interface ValidatorConvertible {
    @Throws(ValidationException::class)
    fun validated(value: String): String
}

class UserNameValidator: ValidatorConvertible {

    override fun validated(value: String): String {
        when {
            value.isEmpty() -> throw ValidationException.IsEmpty("isEmpty")
            value.isContainsSpecialChars() -> throw ValidationException.ContainsSpecialChar("containsSpecialChar")
        }
        return value
    }
}

class PasswordValidator: ValidatorConvertible {

    override fun validated(value: String): String {
        when {
            value.isEmpty() -> throw ValidationException.IsEmpty("isEmpty")
        }
        return value
    }
}

/*:

 ## Liskov Substitution Principle (LSP) 里氏替換原則

 * 程式中的物件應該是可以在不改變程式正確性的前提下被它的子類所替換的

 */

open class Rectangle(protected val height: Int, protected val width: Int) {

    open fun getArea(): String {
        return "${height * width}"
    }
}

class Square(height: Int, width: Int) : Rectangle(height, width) {
    override fun getArea(): String {
        return if (height != width) {
            "長寬需一致"
        } else {
            super.getArea()
        }
    }
}

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
interface Car {
    fun startEngine()
    fun stopEngine()
    fun enableDebugMode()
}

class Driver: Car {
    override fun startEngine() {
        println("start engine")
    }

    override fun stopEngine() {
        println("stop engine")
    }

    override fun enableDebugMode() {
        println("enable debug mode")
    }
}

class Engineer: Car {
    override fun startEngine() {
        println("start engine")
    }

    override fun stopEngine() {
        println("stop engine")
    }

    override fun enableDebugMode() {
        println("enable debug mode")
    }
}

/*:
 工程師可以開啟 DebugMode, 但駕駛使用者不應該可以開啟 DebugMode
 */

/*:
 ### After
 */

interface Car1 {
    fun startEngine()
    fun stopEngine()
}

interface Debuggable {
    fun enableDebugMode()
}

class Driver1: Car1 {
    override fun startEngine() {
        println("start engine")
    }

    override fun stopEngine() {
        println("stop engine")
    }
}

class Engineer1: Car1, Debuggable {
    override fun startEngine() {
        println("start engine")
    }

    override fun stopEngine() {
        println("stop engine")
    }

    override fun enableDebugMode() {
        println("enable debug mode")
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
    val no: Int
    val device: List<String>

    constructor(no: Int, device: List<String>) {
        this.no = no
        this.device = device
    }
}

/*:
 ### Before
 */

class SQLiteService {
    fun saveRoom(room: Room) {
        println("SQLiteService save")
    }

    fun deleteRoom(no: Int) {
        println("SQLiteService delete")
    }
}

class RoomActivity {
    var sqlDBService: SQLiteService? = null

    constructor(sqlDBService: SQLiteService) {
        this.sqlDBService = sqlDBService
    }

    fun saveRoomToDB(room: Room) {
        sqlDBService?.saveRoom(room)
    }

    fun deleteRoomFromDB(no: Int) {
        sqlDBService?.deleteRoom(no)
    }
}

/*:
 如果今天 SQLite 因某些問題(速度過慢等等...)因素，導致我們必須換成 CoreData 或其他 Database 呢?
 */

interface DataBaseService {
    fun saveRoom(room: Room)
    fun deleteRoom(no: Int)
}

class SQLiteDBService: DataBaseService {
    override fun saveRoom(room: Room) {
        println("SQLiteDBService save")
    }

    override fun deleteRoom(no: Int) {
        println("SQLiteDBService delete")
    }
}

class CoreDataDBService: DataBaseService {
    override fun saveRoom(room: Room) {
        println("CoreDataDBService save")
    }

    override fun deleteRoom(no: Int) {
        println("CoreDataDBService delete")
    }
}

class MySQLDBService: DataBaseService {
    override fun saveRoom(room: Room) {
        println("MySQLDBService save")
    }

    override fun deleteRoom(no: Int) {
        println("MySQLDBService delete")
    }
}

class Room2Activity {
    var databaseService: DataBaseService? = null

    constructor(databaseService: DataBaseService) {
        this.databaseService = databaseService
    }

    fun saveRoomToDB(room: Room) {
        databaseService?.saveRoom(room)
    }

    fun deleteRoomFromDB(no: Int) {
        databaseService?.deleteRoom(no)
    }
}

fun main() {
    // Encapsulate What Varies
    orderPancake("classic")
    orderPancakeWithFactory("blueberry")

    // Liskov Substitution Principle
    val rectangle = Rectangle(2, 3)
    println("${rectangle.getArea()}")
    val square = Square(2, 3)
    println("${square.getArea()}")

    // Dependency Inversion Principle
    // Before
    val roomVC = RoomActivity(SQLiteService())
    val room = Room(1, listOf("IPCam", "VDP"))
    roomVC.saveRoomToDB(room)
    roomVC.deleteRoomFromDB(room.no)

    // After
    val sqliteDB = SQLiteDBService()
    val coreDataDB = CoreDataDBService()
    val mysqlDB = MySQLDBService()

    val room2VC = Room2Activity(sqliteDB)
    val room2 = Room(2, listOf("IPCam", "VDP"))

    // sql
    room2VC.saveRoomToDB(room2)
    room2VC.deleteRoomFromDB(room2.no)

    // coredata
    room2VC.databaseService = coreDataDB
    room2VC.saveRoomToDB(room2)
    room2VC.deleteRoomFromDB(room2.no)

    // mysql
    room2VC.databaseService = mysqlDB
    room2VC.saveRoomToDB(room2)
    room2VC.deleteRoomFromDB(room2.no)
}
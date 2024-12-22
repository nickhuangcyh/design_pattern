package mediatorpattern.source

class ChatRoomMediator : ChatMediator {
    private val users = mutableListOf<User>()

    override fun sendMessage(message: String, user: User) {
        users.filter { it != user }.forEach { it.receive(message) }
    }

    override fun addUser(user: User) {
        users.add(user)
    }
}
package mediatorpattern.source

interface ChatMediator {
    fun sendMessage(message: String, user: User)
    fun addUser(user: User)
}
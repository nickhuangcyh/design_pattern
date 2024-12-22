package mediatorpattern.source

class ChatUser(mediator: ChatMediator, name: String) : User(mediator, name) {
    override fun send(message: String) {
        println("$name 發送訊息：$message")
        mediator.sendMessage(message, this)
    }

    override fun receive(message: String) {
        println("$name 收到訊息：$message")
    }
}
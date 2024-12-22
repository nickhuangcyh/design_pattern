package mediatorpattern.source

abstract class User(protected val mediator: ChatMediator, val name: String) {
    abstract fun send(message: String)
    abstract fun receive(message: String)
}
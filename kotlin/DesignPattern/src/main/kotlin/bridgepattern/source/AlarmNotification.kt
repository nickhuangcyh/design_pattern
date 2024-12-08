package bridgepattern.source

abstract class AlarmNotification(sender: MessageSender) {
    protected var sender: MessageSender

    init {
        this.sender = sender
    }

    abstract fun notifyUser(details: String?)
}
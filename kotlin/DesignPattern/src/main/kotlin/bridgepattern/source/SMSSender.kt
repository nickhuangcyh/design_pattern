package bridgepattern.source

class SMSSender : MessageSender {
    override fun sendMessage(message: String?) {
        println("Sending SMS: $message")
    }
}
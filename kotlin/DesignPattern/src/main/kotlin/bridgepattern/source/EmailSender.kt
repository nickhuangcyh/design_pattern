package bridgepattern.source

class EmailSender : MessageSender {
    override fun sendMessage(message: String?) {
        println("Sending Email: $message")
    }
}
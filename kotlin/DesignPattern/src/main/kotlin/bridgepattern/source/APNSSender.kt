package bridgepattern.source

class APNSSender : MessageSender {
    override fun sendMessage(message: String?) {
        println("Sending APNS Notification: $message")
    }
}
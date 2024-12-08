package bridgepattern.source

class FCMSender : MessageSender {
    override fun sendMessage(message: String?) {
        println("Sending FCM Notification: $message")
    }
}
package bridgepattern.source

class BurglarAlarmNotification(sender: MessageSender) : AlarmNotification(sender) {
    override fun notifyUser(details: String?) {
        sender.sendMessage("Theft Alarm: $details")
    }
}
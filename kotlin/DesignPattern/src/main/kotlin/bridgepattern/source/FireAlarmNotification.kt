package bridgepattern.source

class FireAlarmNotification(sender: MessageSender) : AlarmNotification(sender) {
    override fun notifyUser(details: String?) {
        sender.sendMessage("Fire Alarm: $details")
    }
}
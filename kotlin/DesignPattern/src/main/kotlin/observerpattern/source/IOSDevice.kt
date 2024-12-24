package observerpattern.source

class IOSDevice : Device {
    override fun onAlarmTriggered(alarmMessage: String) {
        println("iOS 設備收到通知: $alarmMessage")
    }
}
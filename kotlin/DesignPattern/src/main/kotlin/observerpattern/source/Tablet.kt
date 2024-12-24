package observerpattern.source

class Tablet : Device {
    override fun onAlarmTriggered(alarmMessage: String) {
        println("平板收到通知: $alarmMessage")
    }
}
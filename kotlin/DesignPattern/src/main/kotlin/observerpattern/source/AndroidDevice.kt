package observerpattern.source

class AndroidDevice : Device {
    override fun onAlarmTriggered(alarmMessage: String) {
        println("Android 設備收到通知: $alarmMessage")
    }
}
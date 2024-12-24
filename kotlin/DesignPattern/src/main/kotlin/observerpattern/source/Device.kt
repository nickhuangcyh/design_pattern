package observerpattern.source

interface Device {
    fun onAlarmTriggered(alarmMessage: String)
}
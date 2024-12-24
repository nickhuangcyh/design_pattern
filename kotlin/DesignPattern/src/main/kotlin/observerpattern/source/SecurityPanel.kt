package observerpattern.source

class SecurityPanel : AlarmSystem {
    private val devices = mutableListOf<Device>()

    override fun addObserver(observer: Device) {
        devices.add(observer)
    }

    override fun removeObserver(observer: Device) {
        devices.remove(observer)
    }

    override fun notifyObservers(alarmMessage: String) {
        for (device in devices) {
            device.onAlarmTriggered(alarmMessage)
        }
    }

    fun triggerAlarm(zone: String) {
        val message = "警報觸發於 $zone!"
        println("主機通知: $message")
        notifyObservers(message)
    }
}
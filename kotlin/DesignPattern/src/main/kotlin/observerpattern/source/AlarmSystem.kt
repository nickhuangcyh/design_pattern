package observerpattern.source

interface AlarmSystem {
    fun addObserver(observer: Device)
    fun removeObserver(observer: Device)
    fun notifyObservers(alarmMessage: String)
}
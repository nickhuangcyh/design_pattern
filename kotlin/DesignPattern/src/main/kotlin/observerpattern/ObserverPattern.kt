package observerpattern

import observerpattern.source.AndroidDevice
import observerpattern.source.IOSDevice
import observerpattern.source.SecurityPanel
import observerpattern.source.Tablet

fun main() {
    val securityPanel = SecurityPanel()

    val tablet = Tablet()
    val iosDevice = IOSDevice()
    val androidDevice = AndroidDevice()

    // add observers
    securityPanel.addObserver(tablet)
    securityPanel.addObserver(iosDevice)
    securityPanel.addObserver(androidDevice)

    // trigger alarm
    securityPanel.triggerAlarm("客廳")
    securityPanel.triggerAlarm("廚房")

    // remove observer
    securityPanel.removeObserver(androidDevice)
    securityPanel.triggerAlarm("臥室")
}
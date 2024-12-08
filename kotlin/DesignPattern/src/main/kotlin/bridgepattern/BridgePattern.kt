package bridgepattern

import bridgepattern.source.*
import bridgepattern.source.APNSSender
import bridgepattern.source.BurglarAlarmNotification
import bridgepattern.source.FCMSender
import bridgepattern.source.FireAlarmNotification

fun main() {
    // Sending Fire Alarm via APNS
    val fireAPNS: AlarmNotification = FireAlarmNotification(APNSSender())
    fireAPNS.notifyUser("Smoke detected in Zone 1.")

    // Sending Burglar Alarm via FCM
    val burglarFCM: AlarmNotification = BurglarAlarmNotification(FCMSender())
    burglarFCM.notifyUser("Unauthorized access detected at Main Door.")

    // Sending Fire Alarm via Email
    val fireEmail: AlarmNotification = FireAlarmNotification(EmailSender())
    fireEmail.notifyUser("Temperature exceeds threshold in Zone 3.")

    // Sending Burglar Alarm via SMS
    val burglarSMS: AlarmNotification = BurglarAlarmNotification(SMSSender())
    burglarSMS.notifyUser("Motion detected in Warehouse.")
}
package chainofresponsibilitypattern.source

class DatabaseLogger(nextLogger: Logger? = null) : Logger(nextLogger) {

    override fun log(level: LogLevel, message: String) {
        if (level == LogLevel.ERROR) {
            println("DatabaseLogger: $message")
        }
        passToNext(level, message)
    }
}
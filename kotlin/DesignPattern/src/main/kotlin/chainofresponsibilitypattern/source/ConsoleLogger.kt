package chainofresponsibilitypattern.source

class ConsoleLogger(nextLogger: Logger? = null) : Logger(nextLogger) {

    override fun log(level: LogLevel, message: String) {
        if (level == LogLevel.INFO) {
            println("ConsoleLogger: $message")
        }
        passToNext(level, message)
    }
}
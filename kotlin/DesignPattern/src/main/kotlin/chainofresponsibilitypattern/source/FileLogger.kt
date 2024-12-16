package chainofresponsibilitypattern.source

class FileLogger(nextLogger: Logger? = null) : Logger(nextLogger) {

    override fun log(level: LogLevel, message: String) {
        if (level == LogLevel.WARNING) {
            println("FileLogger: $message")
        }
        passToNext(level, message)
    }
}
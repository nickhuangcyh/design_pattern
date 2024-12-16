package chainofresponsibilitypattern.source

abstract class Logger(private val nextLogger: Logger? = null) {

    abstract fun log(level: LogLevel, message: String)

    protected fun passToNext(level: LogLevel, message: String) {
        nextLogger?.log(level, message)
    }
}
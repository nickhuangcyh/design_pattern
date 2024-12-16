package chainofresponsibilitypattern

import chainofresponsibilitypattern.source.ConsoleLogger
import chainofresponsibilitypattern.source.DatabaseLogger
import chainofresponsibilitypattern.source.FileLogger
import chainofresponsibilitypattern.source.LogLevel

fun main() {
    val loggerChain = ConsoleLogger(FileLogger(DatabaseLogger()))

    println("Sending INFO log...")
    loggerChain.log(LogLevel.INFO, "This is an informational message.")

    println("\nSending WARNING log...")
    loggerChain.log(LogLevel.WARNING, "This is a warning message.")

    println("\nSending ERROR log...")
    loggerChain.log(LogLevel.ERROR, "This is an error message.")
}
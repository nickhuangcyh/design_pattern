package commandpattern.source

class RemoteControl {
    private val commandHistory = mutableListOf<Command>()

    fun pressButton(command: Command) {
        command.execute()
        commandHistory.add(command)
    }

    fun pressUndo() {
        if (commandHistory.isNotEmpty()) {
            val lastCommand = commandHistory.removeLast()
            lastCommand.undo()
        } else {
            println("No command to undo")
        }
    }
}
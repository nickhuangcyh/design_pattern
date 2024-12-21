package commandpattern.source

interface Command {
    fun execute()
    fun undo()
}
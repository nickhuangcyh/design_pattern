package commandpattern.source

class StopCommand(private val player: MusicPlayer) : Command {
    override fun execute() {
        player.stop()
    }

    override fun undo() {
        println("Cannot undo stop") // Undo stop
    }
}
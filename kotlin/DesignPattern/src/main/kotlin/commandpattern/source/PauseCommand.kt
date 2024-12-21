package commandpattern.source

class PauseCommand(private val player: MusicPlayer) : Command {
    override fun execute() {
        player.pause()
    }

    override fun undo() {
        player.play() // Undo pause
    }
}
package commandpattern.source

class PlayCommand(private val player: MusicPlayer) : Command {
    override fun execute() {
        player.play()
    }

    override fun undo() {
        player.pause() // Undo play
    }
}
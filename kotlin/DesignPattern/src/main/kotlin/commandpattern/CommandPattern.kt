package commandpattern

import commandpattern.source.*

fun main() {
    val player = MusicPlayer()

    val playCommand = PlayCommand(player)
    val pauseCommand = PauseCommand(player)
    val stopCommand = StopCommand(player)

    val remoteControl = RemoteControl()

    // Play music
    remoteControl.pressButton(playCommand)

    // Pause music
    remoteControl.pressButton(pauseCommand)

    // Undo
    remoteControl.pressUndo()

    // Stop music
    remoteControl.pressButton(stopCommand)

    // Undo
    remoteControl.pressUndo()
}
package facadepattern.source

class HomeTheaterFacade(
    private val dvdPlayer: DVDPlayer,
    private val surroundSound: SurroundSound,
    private val lights: Lights,
    private val projector: Projector
) {
    fun watchMovie() {
        println("Get ready to watch a movie...")
        lights.dim(10)
        projector.on()
        projector.setMode("Cinema")
        surroundSound.on()
        surroundSound.setVolume(5)
        dvdPlayer.on()
        dvdPlayer.play()
    }

    fun endMovie() {
        println("Shutting down the home theater...")
        dvdPlayer.off()
        surroundSound.off()
        projector.off()
        lights.on()
    }
}
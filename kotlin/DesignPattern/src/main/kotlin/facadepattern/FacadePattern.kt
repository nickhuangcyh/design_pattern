package facadepattern

import facadepattern.source.*

fun main() {
    val dvdPlayer = DVDPlayer()
    val surroundSound = SurroundSound()
    val lights = Lights()
    val projector = Projector()

    val homeTheater = HomeTheaterFacade(dvdPlayer, surroundSound, lights, projector)

    // The Start
    homeTheater.watchMovie()

    println()

    // The End
    homeTheater.endMovie()
}
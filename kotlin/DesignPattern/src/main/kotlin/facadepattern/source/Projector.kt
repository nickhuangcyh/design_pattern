package facadepattern.source

class Projector {
    fun on() = println("Projector is ON")
    fun setMode(mode: String) = println("Projector set to $mode mode")
    fun off() = println("Projector is OFF")
}
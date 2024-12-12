package facadepattern.source

class SurroundSound {
    fun on() = println("Surround Sound is ON")
    fun setVolume(level: Int) = println("Surround Sound volume set to $level")
    fun off() = println("Surround Sound is OFF")
}

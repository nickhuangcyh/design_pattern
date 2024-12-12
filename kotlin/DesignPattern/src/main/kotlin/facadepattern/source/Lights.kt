package facadepattern.source

class Lights {
    fun dim(level: Int) = println("Lights dimmed to $level%")
    fun on() = println("Lights are ON")
}
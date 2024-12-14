package flyweightpattern.source

class TreeType(
    val name: String,
    val color: String,
    val texture: String
) {
    fun draw(x: Int, y: Int) {
        println("Drawing tree: $name, color: $color, texture: $texture at ($x, $y)")
    }
}
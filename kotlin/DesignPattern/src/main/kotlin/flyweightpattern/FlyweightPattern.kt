package flyweightpattern

import flyweightpattern.source.Forest

fun main() {
    val forest = Forest()

    // Planting trees in the forest
    forest.plantTree(10, 20, "Oak", "Green", "Rough")
    forest.plantTree(15, 25, "Pine", "Dark Green", "Smooth")
    forest.plantTree(10, 20, "Oak", "Green", "Rough") // Reuses the same TreeType as the first Oak

    // Draw all trees
    forest.draw()
}
package prototypepattern

import prototypepattern.source.LightShowData
import prototypepattern.source.LightShowDataPrototype

fun main() {
    val originalData = listOf(1, 2, 3, 4, 5)

    // Before using prototype pattern
    val originalLightShowData: LightShowDataPrototype = LightShowData(originalData)
    val newLightShowData: LightShowDataPrototype = LightShowData(originalData)

    println(originalLightShowData)
    println(newLightShowData)

    // After using prototype pattern
    val clonedLightShowData: LightShowDataPrototype = LightShowData(originalData)

    println(originalLightShowData)
    println(clonedLightShowData)
}
package builderpattern

import builderpattern.source.BeverageMaker
import builderpattern.source.BubbleTeaBuilder
import builderpattern.source.GrassJellyPuddingTeaBuilder

fun main() {
    val bubbleTeaBuilder = BubbleTeaBuilder()
    val bubbleTeaBeverageMaker = BeverageMaker(bubbleTeaBuilder)
    val bubbleTea = bubbleTeaBeverageMaker.makeBubbleTea()
    println(bubbleTea)

    val grassJellyPuddingTeaBuilder = GrassJellyPuddingTeaBuilder()
    val grassJellyPuddingTeaBeverageMaker = BeverageMaker(grassJellyPuddingTeaBuilder)
    val grassJellyPuddingTea = grassJellyPuddingTeaBeverageMaker.makeGrassJellyPuddingTea()
    println(grassJellyPuddingTea)
}
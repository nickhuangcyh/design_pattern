package builderpattern.source

class BeverageMaker(val builder: Builder) {
    fun makeBubbleTea(): Beverage {
        return builder.addPearls().build()
    }

    fun makeGrassJellyPuddingTea(): Beverage {
        return builder.addGrassJelly().addPudding().build()
    }
}
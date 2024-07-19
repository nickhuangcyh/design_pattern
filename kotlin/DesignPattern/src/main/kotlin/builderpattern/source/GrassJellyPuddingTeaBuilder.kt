package builderpattern.source

class GrassJellyPuddingTeaBuilder: Builder {

    private var grassJellyPuddingTea = GrassJellyPuddingTea(
        false,
        hasCoconutJelly = false,
        hasRedBeans = false,
        hasGrassJelly = false,
        hasPudding = false
    )

    override fun addPearls(): Builder {
        return this
    }

    override fun addGrassJelly(): GrassJellyPuddingTeaBuilder {
        grassJellyPuddingTea.hasGrassJelly = true
        return this
    }

    override fun addPudding(): GrassJellyPuddingTeaBuilder {
        grassJellyPuddingTea.hasPudding = true
        return this
    }

    override fun build(): GrassJellyPuddingTea {
        return grassJellyPuddingTea
    }
}
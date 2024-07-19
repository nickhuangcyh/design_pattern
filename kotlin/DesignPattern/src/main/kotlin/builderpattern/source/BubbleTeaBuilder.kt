package builderpattern.source

class BubbleTeaBuilder: Builder {
    private var bubbleTea = BubbleTea(false)

    override fun addPearls(): BubbleTeaBuilder {
        bubbleTea.hasPearls = true
        return this
    }

    override fun addPudding(): Builder {
        return this
    }

    override fun addGrassJelly(): Builder {
        return this
    }

    override fun build(): BubbleTea {
        return bubbleTea
    }
}
package builderpattern.source

interface Builder {
    fun addPearls(): Builder
    fun addPudding(): Builder
    fun addGrassJelly(): Builder

    fun build(): Beverage
}
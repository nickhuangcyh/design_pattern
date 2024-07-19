package builderpattern.source

data class BubbleTea(override var hasPearls: Boolean,
                     override var hasCoconutJelly: Boolean = false,
                     override var hasRedBeans: Boolean = false,
                     override var hasGrassJelly: Boolean = false,
                     override var hasPudding: Boolean = false
): Beverage {
}
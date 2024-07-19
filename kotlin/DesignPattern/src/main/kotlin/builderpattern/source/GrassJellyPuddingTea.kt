package builderpattern.source

data class GrassJellyPuddingTea(override var hasPearls: Boolean = false,
                                override var hasCoconutJelly: Boolean = false,
                                override var hasRedBeans: Boolean = false,
                                override var hasGrassJelly: Boolean,
                                override var hasPudding: Boolean
): Beverage {
}

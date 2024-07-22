package prototypepattern.source

interface LightShowDataPrototype {
    val startIndex: Int
    val lightDataList: List<Int>
    fun clone(): LightShowDataPrototype
}
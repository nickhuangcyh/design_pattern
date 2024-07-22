package prototypepattern.source

class LightShowData: LightShowDataPrototype {

    override val startIndex: Int
    override val lightDataList: List<Int>

    constructor(originalDataList: List<Int>) {
        startIndex = originalDataList[0]
        lightDataList = originalDataList.subList(1, originalDataList.size).map { it * 2 }
    }

    constructor(startIndex: Int, lightDataList: List<Int>) {
        this.startIndex = startIndex
        this.lightDataList = lightDataList
    }

    override fun clone(): LightShowDataPrototype {
        return LightShowData(startIndex, lightDataList.toList())
    }
}

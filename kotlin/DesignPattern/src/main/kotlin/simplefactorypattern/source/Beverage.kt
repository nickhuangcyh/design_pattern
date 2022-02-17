package simplefactorypattern.source

interface Beverage {
    fun addSuger(level: Int) {
        println("[$this] addSuger $level")
    }

    fun addIce(level: Int) {
        println("[$this] addIce $level")
    }

    fun shake() {
        println("[$this] shake")
    }

    fun packageUp() {
        println("[$this] packageUp")
    }
}
package abstractfactorypattern.source

interface BeverageFactory {
    fun createBlackTea(): BlackTea
    fun createGreenTea(): GreenTea
}
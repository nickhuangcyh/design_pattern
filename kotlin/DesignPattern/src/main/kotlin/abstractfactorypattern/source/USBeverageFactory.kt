package abstractfactorypattern.source

class USBeverageFactory: BeverageFactory {

    override fun createBlackTea(): BlackTea {
        return CeylonBlackTea()
    }

    override fun createGreenTea(): GreenTea {
        return GyokuroGreenTea()
    }
}
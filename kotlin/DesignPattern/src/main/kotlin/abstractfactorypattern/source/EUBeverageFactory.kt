package abstractfactorypattern.source

class EUBeverageFactory: BeverageFactory {

    override fun createBlackTea(): BlackTea {
        return EarlGreyBlackTea()
    }

    override fun createGreenTea(): GreenTea {
        return SenchaGreenTea()
    }
}
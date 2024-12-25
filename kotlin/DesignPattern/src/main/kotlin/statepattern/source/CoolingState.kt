package statepattern.source

class CoolingState : WaterDispenserState {
    override fun handleRequest() {
        println("冷卻中：水溫正在降低，請稍候...")
    }
}
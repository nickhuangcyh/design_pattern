package statepattern.source

class HeatingState : WaterDispenserState {
    override fun handleRequest() {
        println("加熱中：水溫正在提升，請稍候...")
    }
}
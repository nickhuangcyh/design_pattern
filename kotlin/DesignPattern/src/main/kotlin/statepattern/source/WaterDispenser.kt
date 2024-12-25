package statepattern.source

class WaterDispenser {
    private var currentState: WaterDispenserState = StandbyState()

    fun setState(state: WaterDispenserState) {
        currentState = state
        println("狀態切換：${state::class.simpleName}")
    }

    fun pressButton() {
        currentState.handleRequest()
    }
}
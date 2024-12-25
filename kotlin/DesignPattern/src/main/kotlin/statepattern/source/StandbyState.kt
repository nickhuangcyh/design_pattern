package statepattern.source

class StandbyState : WaterDispenserState {
    override fun handleRequest() {
        println("待機中：飲水機維持現有水溫，隨時可用。")
    }
}
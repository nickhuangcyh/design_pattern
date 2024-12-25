package statepattern

import statepattern.source.CoolingState
import statepattern.source.HeatingState
import statepattern.source.StandbyState
import statepattern.source.WaterDispenser

fun main() {
    val dispenser = WaterDispenser()

    // 初始狀態為待機中
    dispenser.pressButton()

    // 切換到加熱狀態
    dispenser.setState(HeatingState())
    dispenser.pressButton()

    // 切換到冷卻狀態
    dispenser.setState(CoolingState())
    dispenser.pressButton()

    // 回到待機狀態
    dispenser.setState(StandbyState())
    dispenser.pressButton()
}
package adapterpattern

import adapterpattern.source.StockDataAdapter
import adapterpattern.source.XmlStockData

fun main() {
    val xmlStockData = XmlStockData()
    val adapter = StockDataAdapter(xmlStockData)

    adapter.convertAndAnalyze()
}
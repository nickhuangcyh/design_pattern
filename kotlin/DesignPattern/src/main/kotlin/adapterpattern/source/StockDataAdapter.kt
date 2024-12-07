package adapterpattern.source

import org.json.XML

class StockDataAdapter(private val xmlStockData: XmlStockData) : JsonAnalyzer {
    override fun analyzeJsonData(json: String) {
        println("Analyzing JSON data: $json")
    }

    fun convertAndAnalyze() {
        val xml = xmlStockData.getXmlData()
        val json = XML.toJSONObject(xml).toString(4)
        analyzeJsonData(json)
    }
}
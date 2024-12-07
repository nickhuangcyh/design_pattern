package adapterpattern.source

class XmlStockData {
    fun getXmlData(): String {
        return """
            <stocks>
                <stock>
                    <symbol>TSLA</symbol>
                    <price>675.50</price>
                </stock>
                <stock>
                    <symbol>AMZN</symbol>
                    <price>3201.65</price>
                </stock>
            </stocks>
        """
    }
}
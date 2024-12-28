package templatemethodpattern.source

class XmlFormatter : DataFormatter() {
    override fun formatData(data: String): String {
        return "<data>$data</data>" // 模擬 XML 格式化
    }

    override fun outputData(data: String): String {
        return "XML Output: $data"
    }
}
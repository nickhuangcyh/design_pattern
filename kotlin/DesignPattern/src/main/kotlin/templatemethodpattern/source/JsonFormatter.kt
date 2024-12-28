package templatemethodpattern.source

class JsonFormatter : DataFormatter() {
    override fun formatData(data: String): String {
        return "{\"data\": \"$data\"}" // 模擬 JSON 格式化
    }

    override fun outputData(data: String): String {
        return "JSON Output: $data"
    }
}
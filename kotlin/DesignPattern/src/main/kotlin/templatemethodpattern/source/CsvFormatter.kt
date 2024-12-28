package templatemethodpattern.source

class CsvFormatter : DataFormatter() {
    override fun formatData(data: String): String {
        return data.replace(", ", "\n") // 模擬 CSV 格式化
    }

    override fun outputData(data: String): String {
        return "CSV Output: $data"
    }
}
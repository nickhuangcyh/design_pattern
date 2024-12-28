package templatemethodpattern.source

abstract class DataFormatter {

    fun convert(data: Map<String, Any>): String {
        val rawData = readData(data)
        val formattedData = formatData(rawData)
        return outputData(formattedData)
    }

    private fun readData(data: Map<String, Any>): String {
        return data.toString()
    }

    // subclass implementation
    protected abstract fun formatData(data: String): String

    protected abstract fun outputData(data: String): String
}
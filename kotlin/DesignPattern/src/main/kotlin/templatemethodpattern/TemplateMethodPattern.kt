package templatemethodpattern

import templatemethodpattern.source.CsvFormatter
import templatemethodpattern.source.JsonFormatter
import templatemethodpattern.source.XmlFormatter

fun main() {
    val data = mapOf("name" to "John", "age" to 30, "city" to "New York")

    val jsonFormatter = JsonFormatter()
    println(jsonFormatter.convert(data))

    val xmlFormatter = XmlFormatter()
    println(xmlFormatter.convert(data))

    val csvFormatter = CsvFormatter()
    println(csvFormatter.convert(data))
}
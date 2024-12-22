package iteratorpattern.source

data class File(val name: String, val isDirectory: Boolean, val children: List<File> = emptyList()) {
    fun listFiles(): List<File> = if (isDirectory) children else emptyList()
}

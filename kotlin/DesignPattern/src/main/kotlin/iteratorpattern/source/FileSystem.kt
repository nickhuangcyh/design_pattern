package iteratorpattern.source

interface FileSystem {
    fun createIterator(): Iterator<File>
}
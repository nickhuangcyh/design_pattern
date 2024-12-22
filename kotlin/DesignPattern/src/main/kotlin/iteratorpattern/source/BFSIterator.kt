package iteratorpattern.source

class BFSIterator(private val root: File) : Iterator<File> {
    private val queue = ArrayDeque<File>()

    init {
        queue.add(root)
    }

    override fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }

    override fun next(): File {
        if (!hasNext()) throw NoSuchElementException()
        val current = queue.removeFirst()
        if (current.isDirectory) {
            queue.addAll(current.listFiles().orEmpty())
        }
        return current
    }
}
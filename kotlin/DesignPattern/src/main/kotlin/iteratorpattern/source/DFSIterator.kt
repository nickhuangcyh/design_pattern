package iteratorpattern.source

class DFSIterator(private val root: File) : Iterator<File> {
    private val stack = ArrayDeque<File>()

    init {
        stack.add(root)
    }

    override fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    override fun next(): File {
        if (!hasNext()) throw NoSuchElementException()
        val current = stack.removeLast()
        if (current.isDirectory) {
            stack.addAll(current.listFiles().orEmpty())
        }
        return current
    }
}
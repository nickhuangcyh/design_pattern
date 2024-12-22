package iteratorpattern.source

class DefaultFileSystem(private val root: File, private val searchMethod: SearchMethod) : FileSystem {
    override fun createIterator(): Iterator<File> {
        return when (searchMethod) {
            SearchMethod.BFS -> BFSIterator(root)
            SearchMethod.DFS -> DFSIterator(root)
        }
    }
}
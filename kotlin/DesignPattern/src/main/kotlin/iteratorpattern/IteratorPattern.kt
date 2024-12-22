package iteratorpattern

import iteratorpattern.source.DefaultFileSystem
import iteratorpattern.source.File
import iteratorpattern.source.SearchMethod

fun main() {
    val fileSystem = DefaultFileSystem(
        root = File(
            name = "root",
            isDirectory = true,
            children = listOf(
                File("file1.txt", false),
                File("folder1", true, listOf(
                    File("file2.txt", false),
                    File("file3.txt", false)
                )),
                File("folder2", true, listOf(
                    File("file4.txt", false)
                ))
            )
        ),
        searchMethod = SearchMethod.BFS
    )

    val iterator = fileSystem.createIterator()
    println("Files:")
    while (iterator.hasNext()) {
        println("- ${iterator.next().name}")
    }
}
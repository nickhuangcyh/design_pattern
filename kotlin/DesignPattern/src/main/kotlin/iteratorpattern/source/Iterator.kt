package iteratorpattern.source

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}
package mementopattern.source

class History {
    private val mementos = mutableListOf<TextEditor.Memento>()

    fun save(memento: TextEditor.Memento) {
        mementos.add(memento)
    }

    fun undo(): TextEditor.Memento? {
        if (mementos.isNotEmpty()) {
            return mementos.removeAt(mementos.size - 1)
        }
        return null
    }
}
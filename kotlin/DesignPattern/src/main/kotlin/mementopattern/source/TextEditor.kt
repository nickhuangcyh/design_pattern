package mementopattern.source

class TextEditor {
    private var text: String = ""

    fun type(newText: String) {
        text += newText
    }

    fun getText(): String = text

    fun save(): Memento = Memento(text)

    fun restore(memento: Memento) {
        text = memento.getText()
    }

    data class Memento(private val state: String) {
        fun getText(): String = state
    }
}
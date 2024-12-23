package mementopattern

import mementopattern.source.History
import mementopattern.source.TextEditor

fun main() {
    val textEditor = TextEditor()
    val history = History()

    // Typing string
    textEditor.type("Hello")
    history.save(textEditor.save())

    textEditor.type(", World")
    history.save(textEditor.save())

    textEditor.type("! This is Memento Pattern.")
    println("Current Text：${textEditor.getText()}") // Output: Hello, World! This is Memento Pattern.

    // Pressed Ctrl+Z
    textEditor.restore(history.undo()!!)
    println("Excute undo Text：${textEditor.getText()}") // Output: Hello, World!

    // Pressed Ctrl+Z again
    textEditor.restore(history.undo()!!)
    println("Excute undo Text：${textEditor.getText()}") // Output: Hello
}
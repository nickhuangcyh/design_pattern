package designprinciple.source

interface Pancake {
    fun cook() {
        println("[$this] cook")
    }

    fun plate() {
        println("[$this] plate")
    }

    fun addButter() {
        println("[$this] addButter")
    }
}
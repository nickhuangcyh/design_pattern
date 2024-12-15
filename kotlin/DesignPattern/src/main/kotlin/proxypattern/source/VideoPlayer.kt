package proxypattern.source

interface VideoPlayer {
    fun download(name: String): String
    fun play(data: String)
}
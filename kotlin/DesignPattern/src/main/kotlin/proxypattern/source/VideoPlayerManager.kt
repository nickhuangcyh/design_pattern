package proxypattern.source

class VideoPlayerManager(private val player: VideoPlayer) {
    fun playVideo(name: String) {
        println("Request to play video: $name")
        val videoData = player.download(name)
        player.play(videoData)
    }
}
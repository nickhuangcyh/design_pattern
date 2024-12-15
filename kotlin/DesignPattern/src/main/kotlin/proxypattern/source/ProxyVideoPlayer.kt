package proxypattern.source

class ProxyVideoPlayer(
    private val player: YoutubeVideoPlayer
) : VideoPlayer {

    private val cacheVideoList = mutableMapOf<String, String>()

    override fun download(name: String): String {
        return if (cacheVideoList.containsKey(name)) {
            println("Fetching video from cache: $name")
            cacheVideoList[name]!!
        } else {
            println("First time download for: $name")
            val videoData = player.download(name)
            cacheVideoList[name] = videoData
            videoData
        }
    }

    override fun play(data: String) {
        player.play(data)
    }
}
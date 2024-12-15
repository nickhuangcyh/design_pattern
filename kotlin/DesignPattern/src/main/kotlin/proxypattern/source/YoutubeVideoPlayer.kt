package proxypattern.source

class YoutubeVideoPlayer : VideoPlayer {
    override fun download(name: String): String {
        println("Downloading video from YouTube: $name")
        // 模擬下載結果返回的影片資料
        return "VideoData($name)"
    }

    override fun play(data: String) {
        println("Playing video: $data")
    }
}
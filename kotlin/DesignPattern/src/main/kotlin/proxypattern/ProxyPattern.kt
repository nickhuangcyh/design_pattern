package proxypattern

import proxypattern.source.ProxyVideoPlayer
import proxypattern.source.VideoPlayerManager
import proxypattern.source.YoutubeVideoPlayer

fun main() {
    // Using ProxyVideoPlayer
    val youtubePlayer = YoutubeVideoPlayer()
    val proxyPlayer = ProxyVideoPlayer(youtubePlayer)
    val manager = VideoPlayerManager(proxyPlayer)

    // Play video
    manager.playVideo("funny_cats.mp4")
    manager.playVideo("funny_cats.mp4") // using cache
    manager.playVideo("epic_fail.mp4")
    manager.playVideo("funny_cats.mp4") // using cache
}
package visitorpattern.source

class IPCamStreamingVisitor : IPCamVisitor {
    override fun visitHikvision(ipCam: HikvisionIPCam) {
        println("Streaming: ${ipCam.getRTSPStream()}")
    }

    override fun visitDahua(ipCam: DahuaIPCam) {
        println("Streaming: ${ipCam.startSDKStream()}")
    }
}
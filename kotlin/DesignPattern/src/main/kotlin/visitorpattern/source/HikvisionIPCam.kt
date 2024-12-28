package visitorpattern.source

class HikvisionIPCam : IPCam {
    override fun accept(visitor: IPCamVisitor) {
        visitor.visitHikvision(this)
    }

    fun getRTSPStream(): String {
        return "rtsp://hikvision/stream"
    }

    fun captureSnapshot(): String {
        return "Hikvision Snapshot"
    }
}
package visitorpattern

import visitorpattern.source.*

fun main() {
    val ipCams: List<IPCam> = listOf(HikvisionIPCam(), DahuaIPCam())
    val streamingVisitor = IPCamStreamingVisitor()
    val snapshotVisitor = IPCamSnapshotVisitor()

    for (ipCam in ipCams) {
        ipCam.accept(streamingVisitor)
        ipCam.accept(snapshotVisitor)
    }
}
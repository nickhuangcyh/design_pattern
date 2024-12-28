package visitorpattern.source

class IPCamSnapshotVisitor : IPCamVisitor {
    override fun visitHikvision(ipCam: HikvisionIPCam) {
        println("Snapshot: ${ipCam.captureSnapshot()}")
    }

    override fun visitDahua(ipCam: DahuaIPCam) {
        println("Snapshot: ${ipCam.takeSDKSnapshot()}")
    }
}
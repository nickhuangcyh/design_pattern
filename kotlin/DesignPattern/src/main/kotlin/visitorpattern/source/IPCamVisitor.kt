package visitorpattern.source

interface IPCamVisitor {
    fun visitHikvision(ipCam: HikvisionIPCam)
    fun visitDahua(ipCam: DahuaIPCam)
}
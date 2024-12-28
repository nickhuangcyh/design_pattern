package visitorpattern.source

class DahuaIPCam : IPCam {
    override fun accept(visitor: IPCamVisitor) {
        visitor.visitDahua(this)
    }

    fun startSDKStream(): String {
        return "Dahua SDK Stream"
    }

    fun takeSDKSnapshot(): String {
        return "Dahua Snapshot"
    }
}
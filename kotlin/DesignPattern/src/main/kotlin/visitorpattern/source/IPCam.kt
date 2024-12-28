package visitorpattern.source

interface IPCam {
    fun accept(visitor: IPCamVisitor)
}
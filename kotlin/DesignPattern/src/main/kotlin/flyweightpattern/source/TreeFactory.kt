package flyweightpattern.source

object TreeFactory {
    private val treeTypes = mutableMapOf<String, TreeType>()

    fun getTreeType(name: String, color: String, texture: String): TreeType {
        return treeTypes.computeIfAbsent(name) {
            println("Creating new TreeType: $name")
            TreeType(name, color, texture)
        }
    }
}
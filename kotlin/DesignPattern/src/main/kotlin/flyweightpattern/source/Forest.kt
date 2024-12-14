package flyweightpattern.source

class Forest {
    private val trees = mutableListOf<Tree>()

    fun plantTree(x: Int, y: Int, name: String, color: String, texture: String) {
        val treeType = TreeFactory.getTreeType(name, color, texture)
        val tree = Tree(x, y, treeType)
        trees.add(tree)
    }

    fun draw() {
        for (tree in trees) {
            tree.draw()
        }
    }
}
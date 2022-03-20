package leetcode

/**
 * https://leetcode.com/problems/create-binary-tree-from-descriptions/
 */
class Problem2196 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val map = mutableMapOf<Int, TreeNode>()
        val parents = mutableSetOf<Int>()
        val children = mutableSetOf<Int>()
        for (desc in descriptions) {
            val (parent, child) = desc
            parents += parent
            children += child
            if (map[parent] == null) {
                map[parent] = TreeNode(parent)
            }
            if (map[child] == null) {
                map[child] = TreeNode(child)
            }
        }
        for (desc in descriptions) {
            val (parent, child, isLeft) = desc
            val childNode = map[child]
            if (isLeft == 1) {
                map[parent]?.left = if (childNode == null) TreeNode(child) else map[child]
            } else {
                map[parent]?.right = if (childNode == null) TreeNode(child) else map[child]
            }
        }
        parents.removeAll(children)
        return map[parents.elementAtOrNull(0)]
    }
}

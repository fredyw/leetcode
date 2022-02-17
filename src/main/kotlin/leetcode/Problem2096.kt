package leetcode

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 */
class Problem2096 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2096()
    var root = Problem2096.TreeNode(5)
    root.left = Problem2096.TreeNode(1)
    root.left?.left = Problem2096.TreeNode(3)
    root.right = Problem2096.TreeNode(2)
    root.right?.left = Problem2096.TreeNode(6)
    root.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root, 3, 6))

    root = Problem2096.TreeNode(2)
    root.left = Problem2096.TreeNode(1)
    println(prob.getDirections(root, 2, 1))
}
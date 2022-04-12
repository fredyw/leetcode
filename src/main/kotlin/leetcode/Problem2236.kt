package leetcode

/**
 * https://leetcode.com/problems/root-equals-sum-of-children/
 */
class Problem2236 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun checkTree(root: TreeNode?): Boolean {
        return root!!.left!!.`val` + root!!.right!!.`val` == root!!.`val`
    }
}
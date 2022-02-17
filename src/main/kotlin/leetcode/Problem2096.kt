package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 */
class Problem2096 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        var start = getDirection(root, startValue, StringBuilder())
        var dest = getDirection(root, destValue, StringBuilder())
        val minLength = min(start.length, dest.length)
        var i = 0
        while (i < minLength && start[i] == dest[i]) {
            i++
        }
        start = start.substring(i)
        dest = dest.substring(i)
        return "U".repeat(start.length) + dest
    }

    private fun getDirection(root: TreeNode?, `value`: Int, path: StringBuilder): String {
        if (root == null) {
            return ""
        }
        if (root.`val` == value) {
            return path.toString()
        }
        path.append("L")
        val left = getDirection(root.left, value, path)
        path.deleteCharAt(path.length - 1)
        path.append("R")
        val right = getDirection(root.right, value, path)
        path.deleteCharAt(path.length - 1)
        return if (left != "") left else right
    }
}

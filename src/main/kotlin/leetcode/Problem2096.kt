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
        var start = getDirection(root, startValue, "")
        var dest = getDirection(root, destValue, "")
        val minLength = min(start.length, dest.length)
        var i = 0
        while (i < minLength && start[i] == dest[i]) {
            i++
        }
        start = start.substring(i)
        dest = dest.substring(i)
        return "U".repeat(start.length) + dest
    }

    private fun getDirection(root: TreeNode?, `value`: Int, path: String): String {
        if (root == null) {
            return ""
        }
        if (root.`val` == value) {
            return path
        }
        val left = getDirection(root.left, value, "${path}L")
        if (left != "") {
            return left
        }
        return getDirection(root.right, value, "${path}R")
    }
}

fun main() {
    val prob = Problem2096()

    var root1 = Problem2096.TreeNode(5)
    root1.left = Problem2096.TreeNode(1)
    root1.left?.left = Problem2096.TreeNode(3)
    root1.right = Problem2096.TreeNode(2)
    root1.right?.left = Problem2096.TreeNode(6)
    root1.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root1, 3, 6)) // "UURL"

    var root2 = Problem2096.TreeNode(5)
    root2.left = Problem2096.TreeNode(1)
    root2.left?.left = Problem2096.TreeNode(3)
    root2.right = Problem2096.TreeNode(2)
    root2.right?.left = Problem2096.TreeNode(6)
    root2.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root2, 6, 4)) // "UR"

    var root3 = Problem2096.TreeNode(2)
    root3.left = Problem2096.TreeNode(1)
    println(prob.getDirections(root3, 2, 1)) // "L"

    var root4 = Problem2096.TreeNode(5)
    root4.left = Problem2096.TreeNode(1)
    root4.left?.left = Problem2096.TreeNode(3)
    root4.right = Problem2096.TreeNode(2)
    root4.right?.left = Problem2096.TreeNode(6)
    root4.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root4, 1, 3)) // "L"

    var root5 = Problem2096.TreeNode(5)
    root5.left = Problem2096.TreeNode(1)
    root5.left?.left = Problem2096.TreeNode(3)
    root5.right = Problem2096.TreeNode(2)
    root5.right?.left = Problem2096.TreeNode(6)
    root5.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root5, 3, 1)) // "U"
}
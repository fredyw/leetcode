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
        val start = getDirection(root, startValue, "")
        val dest = getDirection(root, destValue, "")
        val minLength = min(start.length, dest.length)
        println("$start - $dest")
        var i = 0
        var j = 0
        while (i < minLength && start[i++] == dest[j++]) {}
        val subStart = start.substring(i - 1)
        val subDest = dest.substring(j - 1)
        println("$subStart - $subDest")
        return ""
    }

    private fun getDirection(root: TreeNode?, `value`: Int, direction: String): String {
        if (root == null) {
            return ""
        }
        if (root.`val` == value) {
            return direction
        }
        val left = getDirection(root.left, value, "${direction}L")
        if (left != "") {
            return left
        }
        return getDirection(root.right, value, "${direction}R")
    }
}

fun main() {
    val prob = Problem2096()

//    var root1 = Problem2096.TreeNode(5)
//    root1.left = Problem2096.TreeNode(1)
//    root1.left?.left = Problem2096.TreeNode(3)
//    root1.right = Problem2096.TreeNode(2)
//    root1.right?.left = Problem2096.TreeNode(6)
//    root1.right?.right = Problem2096.TreeNode(4)
//    println(prob.getDirections(root1, 3, 6)) // "UURL"
//
//    var root2 = Problem2096.TreeNode(5)
//    root2.left = Problem2096.TreeNode(1)
//    root2.left?.left = Problem2096.TreeNode(3)
//    root2.right = Problem2096.TreeNode(2)
//    root2.right?.left = Problem2096.TreeNode(6)
//    root2.right?.right = Problem2096.TreeNode(4)
//    println(prob.getDirections(root2, 6, 4)) // "UR"

//    var root3 = Problem2096.TreeNode(2)
//    root3.left = Problem2096.TreeNode(1)
//    println(prob.getDirections(root3, 2, 1)) // "L"

    var root4 = Problem2096.TreeNode(5)
    root4.left = Problem2096.TreeNode(1)
    root4.left?.left = Problem2096.TreeNode(3)
    root4.right = Problem2096.TreeNode(2)
    root4.right?.left = Problem2096.TreeNode(6)
    root4.right?.right = Problem2096.TreeNode(4)
    println(prob.getDirections(root4, 1, 3)) // "R"
}
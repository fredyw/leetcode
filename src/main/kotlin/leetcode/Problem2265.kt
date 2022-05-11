package leetcode

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 */
class Problem2265 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun averageOfSubtree(root: TreeNode?): Int {
        val answer = IntRef()
        averageOfSubtree(root, answer)
        return answer.value
    }

    private data class SumCount(val sum: Int = 0, val count: Int = 0)
    private data class IntRef(var value: Int = 0)

    private fun averageOfSubtree(root: TreeNode?, answer: IntRef): SumCount {
        if (root == null) {
            return SumCount()
        }
        val left = averageOfSubtree(root.left, answer)
        val right = averageOfSubtree(root.right, answer)
        val newSum = (left.sum + right.sum + root.`val`)
        val newCount = left.count + right.count + 1
        if (newSum / newCount == root.`val`) {
            answer.value++
        }
        return SumCount(newSum, newCount)
    }
}
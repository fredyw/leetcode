package leetcode

/**
 * https://leetcode.com/problems/count-nodes-with-the-highest-score/
 */
class Problem2049 {
    fun countHighestScoreNodes(parents: IntArray): Int {
        val root = buildTree(parents)
        val scores = mutableMapOf<Long, Int>()
        countHighestScore(parents.size, root, scores)
        var answer = 0
        var maxScore = 0L
        for ((score, count) in scores) {
           if (score > maxScore) {
               maxScore = score
               answer = count
           }
        }
        return answer
    }

    data class Node(val value: Int, var left: Node? = null, var right: Node? = null)

    private fun buildTree(parents: IntArray): Node? {
        val nodes = Array(parents.size) { i -> Node(i) }
        var root: Node? = null
        for ((index, parentIndex) in parents.withIndex()) {
            if (parentIndex == -1) {
                root = nodes[0]
            } else {
                val parent = nodes[parentIndex]
                val child = nodes[index]
                if (parent.left == null) {
                    parent.left = child
                } else {
                    parent.right = child
                }
            }
        }
        return root
    }

    private fun countHighestScore(n: Int, root: Node?, scores: MutableMap<Long, Int>): Long {
        if (root == null) {
            return -1
        }
        val left = countHighestScore(n, root.left, scores) + 1
        val right = countHighestScore(n, root.right, scores) + 1
        val score = (if (left == 0L) 1 else left) *
                (if (right == 0L) 1 else right) *
                (if (n - (left + right + 1) == 0L) 1 else n - (left + right + 1))
        scores[score] = (scores[score] ?: 0) + 1
        return left + right
    }
}

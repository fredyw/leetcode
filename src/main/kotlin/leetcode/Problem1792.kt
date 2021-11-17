package leetcode

/**
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 */
class Problem1792 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        TODO()
    }
}

fun main() {
    val prob = Problem1792()
    println(prob.maxAverageRatio(arrayOf(intArrayOf(1,2), intArrayOf(3,5), intArrayOf(2,2)), 2)) // 0.78333
    println(prob.maxAverageRatio(arrayOf(intArrayOf(2,4), intArrayOf(3,9), intArrayOf(4,5), intArrayOf(2,10)), 4)) // 0.53485
}
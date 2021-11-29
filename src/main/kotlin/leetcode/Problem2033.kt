package leetcode

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 */
class Problem2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2033()
    println(prob.minOperations(arrayOf(intArrayOf(2,4), intArrayOf(6,8)), 2)) // 4
    println(prob.minOperations(arrayOf(intArrayOf(1,5), intArrayOf(2,3)), 1)) // 5
    println(prob.minOperations(arrayOf(intArrayOf(1,2), intArrayOf(3,4)), 2)) // -1
    println(prob.minOperations(arrayOf(intArrayOf(1,3), intArrayOf(5,1000)), 4)) // -1
    println(prob.minOperations(arrayOf(intArrayOf(2,6), intArrayOf(8,1000)), 2)) // 500
}
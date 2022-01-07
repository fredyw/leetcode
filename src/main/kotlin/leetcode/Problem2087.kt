package leetcode

/**
 * https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 */
class Problem2087 {
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2087()
    println(prob.minCost(intArrayOf(1, 0), intArrayOf(2, 3), intArrayOf(5, 4, 3), intArrayOf(8, 2, 6, 7))) // 18
    println(prob.minCost(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(5), intArrayOf(26))) // 0
}
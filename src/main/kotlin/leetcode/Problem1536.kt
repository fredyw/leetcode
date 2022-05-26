package leetcode

/**
 * https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
 */
class Problem1536 {
    fun minSwaps(grid: Array<IntArray>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1536()
    println(prob.minSwaps(arrayOf(
        intArrayOf(0,0,1),
        intArrayOf(1,1,0),
        intArrayOf(1,0,0)))) // 3
    println(prob.minSwaps(arrayOf(
        intArrayOf(0,1,1,0),
        intArrayOf(0,1,1,0),
        intArrayOf(0,1,1,0),
        intArrayOf(0,1,1,0)))) // -1
    println(prob.minSwaps(arrayOf(
        intArrayOf(1,0,0),
        intArrayOf(1,1,0),
        intArrayOf(1,1,1)))) // 0
}
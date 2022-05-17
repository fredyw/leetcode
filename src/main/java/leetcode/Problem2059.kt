package leetcode

/**
 * https://leetcode.com/problems/minimum-operations-to-convert-number/
 */
class Problem2059 {
    fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2059()
    println(prob.minimumOperations(intArrayOf(2,4,12), 2, 12)) // 2
    println(prob.minimumOperations(intArrayOf(3,5,7), 0, -4)) // 2
    println(prob.minimumOperations(intArrayOf(2,8,16), 0, 1)) // -1
}
package leetcode

/**
 * https://leetcode.com/problems/k-divisible-elements-subarrays/
 */
class Problem2261 {
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2261()
    println(prob.countDistinct(intArrayOf(2,3,3,2,2), 2, 2)) // 11
    println(prob.countDistinct(intArrayOf(2,3,4,2,2), 2, 2)) // 9
    println(prob.countDistinct(intArrayOf(2,3,5,2,2), 2, 2)) // 12
    println(prob.countDistinct(intArrayOf(1,2,3,4), 4, 1)) // 10
}
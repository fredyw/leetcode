package leetcode

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
class Problem1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1438()
    println(prob.longestSubarray(intArrayOf(8,2,4,7), 4)) // 2
    println(prob.longestSubarray(intArrayOf(10,1,2,4,7,2), 5)) // 4
    println(prob.longestSubarray(intArrayOf(4,2,2,2,4,4,2,2), 0)) // 3
}
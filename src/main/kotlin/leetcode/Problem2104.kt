package leetcode

/**
 * https://leetcode.com/problems/sum-of-subarray-ranges/
 */
class Problem2104 {
    fun subArrayRanges(nums: IntArray): Long {
        TODO()
    }
}

fun main() {
    val prob = Problem2104()
    println(prob.subArrayRanges(intArrayOf(1,2,3))) // 4
    println(prob.subArrayRanges(intArrayOf(1,3,3))) // 4
    println(prob.subArrayRanges(intArrayOf(4,-2,-3,4,1))) // 59
}
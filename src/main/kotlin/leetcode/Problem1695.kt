package leetcode

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */
class Problem1695 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1695()
    println(prob.maximumUniqueSubarray(intArrayOf(4,2,4,5,6))) // 17
    println(prob.maximumUniqueSubarray(intArrayOf(5,2,1,2,5,2,1,2,5))) // 8
    println(prob.maximumUniqueSubarray(intArrayOf(2,4,4,4,5,6,3,4,3))) // 18
    println(prob.maximumUniqueSubarray(intArrayOf(3,4,5,3,8,4,6))) // 26
}
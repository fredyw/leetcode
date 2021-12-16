package leetcode

/**
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */
class Problem2099 {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2099()
    println(prob.maxSubsequence(intArrayOf(2,1,3,3), 2).contentToString()) // [3,3]
    println(prob.maxSubsequence(intArrayOf(-1,-2,3,4), 3).contentToString()) // [-1,3,4]
    println(prob.maxSubsequence(intArrayOf(-1,-2,4,3), 3).contentToString()) // [-1,4,3]
    println(prob.maxSubsequence(intArrayOf(3,4,3,3), 2).contentToString()) // [3,4]
}
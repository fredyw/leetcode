package leetcode

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */
class Problem2149 {
    fun rearrangeArray(nums: IntArray): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2149()
    println(prob.rearrangeArray(intArrayOf(3,1,-2,-5,2,-4)).contentToString()) // [3,-2,1,-5,2,-4]
    println(prob.rearrangeArray(intArrayOf(-1,1)).contentToString()) // [1,-1]
}
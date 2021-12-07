package leetcode

/**
 * https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
 */
class Problem1968 {
    fun rearrangeArray(nums: IntArray): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem1968()
    println(prob.rearrangeArray(intArrayOf(1,2,3,4,5)).contentToString()) // [1,2,4,5,3]
    println(prob.rearrangeArray(intArrayOf(6,2,0,9,7)).contentToString()) // [9,7,6,2,0]
}
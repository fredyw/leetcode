package leetcode

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/
 */
class Problem2161 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2161()
    println(prob.pivotArray(intArrayOf(9,12,5,10,14,3,10), 10).contentToString()) // [9,5,3,10,10,12,14]
    println(prob.pivotArray(intArrayOf(-3,4,3,2), 2).contentToString()) // [-3,2,4,3]
}
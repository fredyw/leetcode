package leetcode

/**
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 */
class Problem1855 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1855()
    println(prob.maxDistance(intArrayOf(55,30,5,4,2), intArrayOf(100,20,10,10,5))) // 2
    println(prob.maxDistance(intArrayOf(2,2,2), intArrayOf(10,10,1))) // 1
    println(prob.maxDistance(intArrayOf(30,29,19,5), intArrayOf(25,25,25,25,25))) // 2
    println(prob.maxDistance(intArrayOf(5,4), intArrayOf(3,2))) // 0
}
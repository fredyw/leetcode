package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 */
class Problem1855 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var answer = 0
        for ((i, num) in nums1.withIndex()) {
            val j = binarySearch(nums2, i, num)
            answer = max(answer, j - i)
        }
        return answer
    }

    private fun binarySearch(nums: IntArray, index: Int, num: Int): Int {
        var lo = index
        var hi = nums.size - 1
        while (lo <= hi) {
            val mid = lo + ((hi - lo) / 2)
            if (num < nums[mid]) {
                lo = mid + 1
            } else if (num == nums[mid]) {
                return mid
            } else {
                hi = mid - 1
            }
        }
        return hi
    }
}

fun main() {
    val prob = Problem1855()
    println(prob.maxDistance(intArrayOf(55,30,5,4,2), intArrayOf(100,20,10,10,5))) // 2
    println(prob.maxDistance(intArrayOf(55,30,6,4,2), intArrayOf(100,20,10,10,7,6))) // 3
    println(prob.maxDistance(intArrayOf(2,2,2), intArrayOf(10,10,1))) // 1
    println(prob.maxDistance(intArrayOf(30,29,19,5), intArrayOf(25,25,25,25,25))) // 2
    println(prob.maxDistance(intArrayOf(5,4), intArrayOf(3,2))) // 0
}
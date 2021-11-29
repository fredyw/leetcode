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
            if (num <= nums[mid]) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }
        return hi
    }
}

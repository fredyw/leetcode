package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */
class Problem2091 {
    fun minimumDeletions(nums: IntArray): Int {
        var minIndex = 0
        var maxIndex = 0
        for ((index, num) in nums.withIndex()) {
            if (num < nums[minIndex]) {
                minIndex = index
            }
            if (num > nums[maxIndex]) {
                maxIndex = index
            }
        }
        if (minIndex == maxIndex) {
            return 1
        } else if (minIndex < maxIndex) {
            // 0----minIndex----maxIndex----(size-1)
            val a = minIndex + 1
            val b = nums.size - maxIndex
            val c = maxIndex - minIndex
            return min(a + b, min(a + c, b + c))
        }
        // 0----maxIndex----minIndex----(size-1)
        val a = maxIndex + 1
        val b = nums.size - minIndex
        val c = minIndex - maxIndex
        return min(a + b, min(a + c, b + c))
    }
}

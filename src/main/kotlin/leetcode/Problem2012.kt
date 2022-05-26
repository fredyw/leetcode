package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/sum-of-beauty-in-the-array/
 */
class Problem2012 {
    fun sumOfBeauties(nums: IntArray): Int {
        val left = IntArray(nums.size)
        for ((i, n) in nums.withIndex()) {
            left[i] = if (i == 0) n else max(left[i - 1], n)
        }
        val right = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
            right[i] = if (i == nums.size - 1) nums[i] else min(right[i + 1], nums[i])
        }
        var answer = 0
        for (i in 1..nums.size - 2) {
            if (left[i - 1] < nums[i] && nums[i] < right[i + 1]) {
                answer += 2
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                answer++
            }
        }
        return answer
    }
}

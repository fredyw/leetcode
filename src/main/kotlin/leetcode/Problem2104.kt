package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/sum-of-subarray-ranges/
 */
class Problem2104 {
    fun subArrayRanges(nums: IntArray): Long {
        var answer = 0L
        for (i in nums.indices) {
            var min = nums[i]
            var max = nums[i]
            for (j in i until nums.size) {
                min = min(min, nums[j])
                max = max(max, nums[j])
                answer += max - min
            }
        }
        return answer
    }
}

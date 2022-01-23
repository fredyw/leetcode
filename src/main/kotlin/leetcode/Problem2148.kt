package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
 */
class Problem2148 {
    fun countElements(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[0]
        for (num in nums) {
            min = min(min, num)
            max = max(max, num)
        }
        var minCount = 0
        var maxCount = 0
        for (num in nums) {
            if (num == min) {
                minCount++
            } else if (num == max) {
                maxCount++
            }
        }
        return nums.size - (minCount + maxCount)
    }
}

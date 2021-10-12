package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */
class Problem1695 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var answer = 0
        val prefixSums = IntArray(nums.size)
        val map = mutableMapOf<Int, Int>()
        var index = 0
        for (i in nums.indices) {
            prefixSums[i] = if (i == 0) nums[i] else prefixSums[i - 1] + nums[i]
            if (nums[i] in map && map[nums[i]]!! >= index) {
                index = map[nums[i]]!! + 1
            }
            val sum = prefixSums[i] - (if (index - 1 >= 0) prefixSums[index - 1] else 0)
            map[nums[i]] = i
            answer = max(answer, sum)
        }
        return answer
    }
}

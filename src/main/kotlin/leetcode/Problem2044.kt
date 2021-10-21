package leetcode

/**
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 */
class Problem2044 {
    fun countMaxOrSubsets(nums: IntArray): Int {
        var max = 0
        for (num in nums) {
            max = max or num
        }
        var answer = 0
        for (i in nums.indices) {
            answer += countMaxOrSubsets(nums, max, i + 1, false, nums[i])
        }
        return answer
    }

    private fun countMaxOrSubsets(nums: IntArray, max: Int, index: Int, skipped: Boolean, accu: Int): Int {
        if (index == nums.size) {
            return if (!skipped && accu == max) 1 else 0
        }
        val count = if (!skipped && accu == max) 1 else 0
        val a = countMaxOrSubsets(nums, max, index + 1, false, accu or nums[index])
        val b = countMaxOrSubsets(nums, max, index + 1, true, accu)
        return a + b + count
    }
}

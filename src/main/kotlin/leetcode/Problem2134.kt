package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
class Problem2134 {
    fun minSwaps(nums: IntArray): Int {
        var numOnes = 0
        for (num in nums) {
            if (num == 1) {
                numOnes++
            }
        }
        var answer = Int.MAX_VALUE
        var numZeros = 0
        var j = 0
        for (i in nums.indices) {
            while (j < i + numOnes) {
                if (nums[j % nums.size] == 0) {
                    numZeros++
                }
                j++
            }
            answer = min(answer, numZeros)
            if (nums[i] == 0) {
                numZeros--
            }
        }
        return if (answer == Int.MAX_VALUE) 0 else answer
    }
}

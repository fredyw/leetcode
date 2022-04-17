package leetcode

import kotlin.math.abs
import kotlin.math.max

/**
 * https://leetcode.com/problems/find-closest-number-to-zero/
 */
class Problem2239 {
    fun findClosestNumber(nums: IntArray): Int {
        var answer = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for (num in nums) {
            if (abs(num - 0) < min) {
                min = abs(num - 0)
                answer = num
            } else if (abs(num - 0) == min) {
                answer = max(answer, num)
            }
        }
        return answer
    }
}

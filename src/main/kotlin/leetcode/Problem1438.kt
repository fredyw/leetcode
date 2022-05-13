package leetcode

import java.util.*
import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
class Problem1438 {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        var answer = 1
        val minDeque = LinkedList<Int>()
        val maxDeque = LinkedList<Int>()
        var left = 0
        for (right in nums.indices) {
            while (minDeque.isNotEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast()
            }
            minDeque.addLast(nums[right])
            while (maxDeque.isNotEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast()
            }
            maxDeque.addLast(nums[right])
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst()
                }
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst()
                }
                left++
            }
            answer = max(answer, right - left + 1)
        }
        return answer
    }
}

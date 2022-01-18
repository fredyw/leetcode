package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 */
class Problem1673 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val stack = Stack<Int>()
        var i = 0
        while (i < nums.size) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size + nums.size - i > k) {
                stack.pop()
            }
            if (stack.size < k) {
                stack.add(nums[i])
            }
            i++
        }
        return stack.toIntArray()
    }
}

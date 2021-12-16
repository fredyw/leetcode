package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */
class Problem2099 {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val queue = PriorityQueue<Int> { a, b -> b.compareTo(a) }
        nums.forEach { queue += it }
        val map = mutableMapOf<Int, Int>()
        var n = k
        while (n > 0) {
            val num = queue.poll()
            map[num] = (map[num] ?: 0) + 1
            n--
        }
        val answer = mutableListOf<Int>()
        for (num in nums) {
            val count = map[num] ?: continue
            answer += num
            if (count - 1 == 0) {
                map -= num
            } else {
                map[num] = count - 1
            }
        }
        return answer.toIntArray()
    }
}

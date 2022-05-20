package leetcode

import java.util.LinkedList
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-operations-to-convert-number/
 */
class Problem2059 {
    fun minimumOperations(nums: IntArray, start: Int, goal: Int): Int {
        var answer = 0
        val queue = LinkedList<Int>()
        val visited = BooleanArray(1001)
        queue.add(start)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val n = queue.remove()
                if (n == goal) {
                    return answer
                }
                if (n < 0 || n > 1000 || visited[n]) {
                    continue
                }
                visited[n] = true
                for (num in nums) {
                    for (m in intArrayOf(n + num, n - num, n xor num)) {
                        queue.add(m)
                    }
                }
            }
            answer++
        }
        return -1
    }
}

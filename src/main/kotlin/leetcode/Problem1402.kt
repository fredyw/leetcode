package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/reducing-dishes/
 */
class Problem1402 {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        return maxSatisfaction(satisfaction, 0, 1, Array(satisfaction.size) {
            IntArray(
                satisfaction.size + 1
            ) { -1 }
        })
    }

    private fun maxSatisfaction(satisfaction: IntArray, index: Int, time: Int, memo: Array<IntArray>): Int {
        if (satisfaction.size == index) {
            return 0
        }
        if (memo[index][time] != -1) {
            return memo[index][time]
        }
        val m = max(
            maxSatisfaction(satisfaction, index + 1, time, memo),
            maxSatisfaction(satisfaction, index + 1, time + 1, memo) + satisfaction[index] * time)
        memo[index][time] = m
        return m
    }
}

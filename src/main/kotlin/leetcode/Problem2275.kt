package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
 */
class Problem2275 {
    fun largestCombination(candidates: IntArray): Int {
        var answer = 0
        var i = 1
        while (i < 10000000) {
            var count = 0
            for (candidate in candidates) {
                if (candidate and i > 0) {
                    count++
                }
            }
            answer = max(answer, count)
            i = i shl 1
        }
        return answer
    }
}

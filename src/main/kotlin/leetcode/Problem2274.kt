package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
 */
class Problem2274 {
    fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
        var answer = 0
        val list = mutableListOf<Int>()
        list += bottom - 1
        list += special.sorted()
        list += top + 1
        for (i in 1 until list.size) {
            val diff = list[i] - list[i - 1] - 1
            answer = max(answer, if (diff > 1) diff else 0)
        }
        return answer
    }
}

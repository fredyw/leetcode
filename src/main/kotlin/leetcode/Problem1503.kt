package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
class Problem1503 {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var answer = 0
        for (i in left) {
           answer = max(answer, i)
        }
        for (i in right) {
            answer = max(answer, n - i)
        }
        return answer
    }
}
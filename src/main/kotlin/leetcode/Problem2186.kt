package leetcode

import kotlin.math.abs

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 */
class Problem2186 {
    fun minSteps(s: String, t: String): Int {
        val sCounts = IntArray(26)
        for (c in s) {
            sCounts[c - 'a']++
        }
        var tCounts = IntArray(26)
        for (c in t) {
            tCounts[c - 'a']++
        }
        var answer = 0
        for (i in sCounts.indices) {
            answer += abs(sCounts[i] - tCounts[i])
        }
        return answer
    }
}

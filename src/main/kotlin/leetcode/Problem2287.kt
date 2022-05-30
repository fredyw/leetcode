package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 */
class Problem2287 {
    fun rearrangeCharacters(s: String, target: String): Int {
        val sCounts = IntArray(26)
        for (c in s) {
            sCounts[c - 'a']++
        }
        val tCounts = IntArray(26)
        for (c in target) {
            tCounts[c - 'a']++
        }
        var answer = Int.MAX_VALUE
        for ((i, t) in tCounts.withIndex()) {
            if (t == 0) {
                continue
            }
            if (sCounts[i] == 0) {
                return 0
            }
            val c = sCounts[i] / t
            if (c == 0) {
                return 0
            }
            answer = min(answer, c)
        }
        return answer
    }
}

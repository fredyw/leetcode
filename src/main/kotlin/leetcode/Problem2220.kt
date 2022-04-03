package leetcode

/**
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 */
class Problem2220 {
    fun minBitFlips(start: Int, goal: Int): Int {
        var answer = 0
        var s = start.toString(2)
        var g = goal.toString(2)
        if (s.length > g.length) {
            g = g.padStart(s.length, '0')
        } else if (s.length < g.length) {
            s = s.padStart(g.length, '0')
        }
        for (i in (s.length - 1)downTo 0) {
            if (s[i] != g[i]) {
                answer++
            }
        }
        return answer
    }
}

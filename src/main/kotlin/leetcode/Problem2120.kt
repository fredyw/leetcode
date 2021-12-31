package leetcode

/**
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */
class Problem2120 {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        val answer = IntArray(s.length)
        for (i in s.indices) {
            var row = startPos[0]
            var col = startPos[1]
            var count = 0
            for (j in i until s.length) {
                when (s[j]) {
                    'L' -> col--
                    'U' -> row--
                    'R' -> col++
                    'D' -> row++
                }
                if (col < 0 || col == n || row < 0 || row == n) {
                    break
                }
                count++
            }
            answer[i] = count
        }
        return answer
    }
}

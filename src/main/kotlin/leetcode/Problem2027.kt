package leetcode

/**
 * https://leetcode.com/problems/minimum-moves-to-convert-string/
 */
class Problem2027 {
    fun minimumMoves(s: String): Int {
        var answer = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == 'O') {
                i++
                continue
            }
            for (j in i until i + 3) {
                if (j >= s.length) {
                    break
                }
                if (s[j] == 'X') {
                    answer++
                    break
                }
            }
            i += 3
        }
        return answer
    }
}
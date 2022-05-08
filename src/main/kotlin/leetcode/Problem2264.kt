package leetcode

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
class Problem2264 {
    fun largestGoodInteger(num: String): String {
        var answer = ""
        var i = 0
        while (i + 3 <= num.length) {
            val s = num.substring(i, i + 3)
            if (sameChars(s)) {
                if (answer < s) {
                    answer = s
                }
            }
            i++
        }
        return answer
    }

    private fun sameChars(s: String): Boolean {
        return s[0] == s[1] && s[1] == s[2]
    }
}

package leetcode

/**
 * https://leetcode.com/problems/number-of-ways-to-select-buildings/
 */
class Problem2222 {
    fun numberOfWays(s: String): Long {
        data class Binary(val zero: Int = 0, val one: Int = 0)
        val left = Array(s.length) { Binary() }
        for (i in s.indices) {
            val zero = if (s[i] == '0') 1 else 0
            val one = if (s[i] == '1') 1 else 0
            left[i] = if (i == 0) {
                Binary(zero, one)
            } else {
                Binary(zero + left[i - 1].zero, one + left[i - 1].one)
            }
        }
        val right = Array(s.length) { Binary() }
        for (i in s.length - 1 downTo 0) {
            val zero = if (s[i] == '0') 1 else 0
            val one = if (s[i] == '1') 1 else 0
            right[i] = if (i == s.length - 1) {
                Binary(zero, one)
            } else {
                Binary(zero + right[i + 1].zero, one + right[i + 1].one)
            }
        }
        var answer = 0L
        for (i in 1..s.length - 2) {
            if (s[i] == '0') { // look for 101
                answer += left[i - 1].one * right[i + 1].one
            } else { // look for 010
                answer += left[i - 1].zero * right[i + 1].zero
            }
        }
        return answer
    }
}

package leetcode

/**
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/
 */
class Problem1759 {
    fun countHomogenous(s: String): Int {
        var answer: Long = 0
        var length: Long = 1
        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                length++
            } else {
                answer += count(length) % 1_000_000_007
                length = 1
            }
        }
        answer += count(length) % 1_000_000_007
        return answer.toInt()
    }

    private fun count(n: Long): Long {
        var sum: Long = 0
        for (i in 1..n) {
            sum += i
        }
        return sum
    }
}

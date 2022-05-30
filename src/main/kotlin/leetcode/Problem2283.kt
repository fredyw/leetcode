package leetcode

/**
 * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
class Problem2283 {
    fun digitCount(num: String): Boolean {
        val counts = IntArray(10)
        for (n in num) {
            counts[n - '0']++
        }
        for ((i, n) in num.withIndex()) {
            if (counts[i] != n - '0') {
                return false
            }
        }
        return true
    }
}

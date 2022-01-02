package leetcode

/**
 * https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 */
class Problem2124 {
    fun checkString(s: String): Boolean {
        return s.matches("a*b*".toRegex())
    }
}

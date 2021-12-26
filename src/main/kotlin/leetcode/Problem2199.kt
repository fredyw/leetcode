package leetcode

/**
 * https://leetcode.com/problems/a-number-after-a-double-reversal/
 */
class Problem2199 {
    fun isSameAfterReversals(num: Int): Boolean {
        return (num == 0) || num % 10 != 0
    }
}

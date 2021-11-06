package leetcode

/**
 * https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
 */
class Problem1798 {
    fun getMaximumConsecutive(coins: IntArray): Int {
        coins.sort()
        var answer = 0
        for (coin in coins) {
            if (coin <= answer + 1) {
                answer += coin
            }
        }
        return answer + 1 // + 1 for 0
    }
}

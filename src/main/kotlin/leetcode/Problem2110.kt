package leetcode

/**
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 */
class Problem2110 {
    fun getDescentPeriods(prices: IntArray): Long {
        var answer = 0L
        var i = 1
        var count = 1L
        while (i < prices.size) {
            if (prices[i - 1] == prices[i] + 1) {
                count++
            } else {
                // https://math.stackexchange.com/questions/1603502/how-to-count-the-number-of-substrings-that-can-be-generated-from-a-given-string
                answer += (count * (count + 1)) / 2
                count = 1
            }
            i++
        }
        answer += (count * (count + 1)) / 2
        return answer
    }
}

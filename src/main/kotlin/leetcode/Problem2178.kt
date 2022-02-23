package leetcode

/**
 * https://leetcode.com/problems/maximum-split-of-positive-even-integers/
 */
class Problem2178 {
    fun maximumEvenSplit(finalSum: Long): List<Long> {
        val answer = mutableListOf<Long>()
        if (finalSum % 2L != 0L) {
            return answer
        }
        var n = finalSum
        var m = 2L
        while (true) {
            if (n - m <= m) {
                answer += n
                break
            }
            n -= m
            answer += m
            m += 2
        }
        return answer
    }
}

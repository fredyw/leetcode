package leetcode

/**
 * https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
 */
class Problem2240 {
    fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
        var answer = 0L
        var penSpent = 0
        var penCount = 0
        while (penSpent <= total) {
            val remaining = total - penSpent
            val pencilCount = remaining / cost2
            answer += pencilCount + 1
            penSpent += cost1
            penCount++
        }
        return answer
    }
}

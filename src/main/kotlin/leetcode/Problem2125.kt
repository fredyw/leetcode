package leetcode

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 */
class Problem2125 {
    fun numberOfBeams(bank: Array<String>): Int {
        var answer = 0
        var previousCount = 0
        for (row in bank) {
            val currentCount = row.count { it == '1' }
            if (currentCount > 0) {
                answer += previousCount * currentCount
                previousCount = currentCount
            }
        }
        return answer
    }
}

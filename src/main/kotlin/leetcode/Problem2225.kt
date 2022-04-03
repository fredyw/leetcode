package leetcode

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
class Problem2225 {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = mutableSetOf<Int>()
        val losers = mutableMapOf<Int, Int>()
        for (match in matches) {
            winners += match[0]
            losers[match[1]] = (losers[match[1]] ?: 0) + 1
        }
        val answer1 = mutableListOf<Int>()
        for (winner in winners) {
            if (winner !in losers) {
                answer1 += winner
            }
        }
        val answer2 = losers.filter { it.value == 1 }.map { it.key }.toMutableList()
        answer1.sort()
        answer2.sort()
        return listOf(answer1, answer2)
    }
}

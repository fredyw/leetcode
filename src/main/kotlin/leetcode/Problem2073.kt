package leetcode

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 */
class Problem2073 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var answer = 0
        while (tickets[k] > 0) {
            for (i in tickets.indices) {
                if (tickets[i] == 0) {
                    continue
                }
                tickets[i]--
                answer++
                if (i == k && tickets[i] == 0) {
                    break
                }
            }
        }
        return answer
    }
}

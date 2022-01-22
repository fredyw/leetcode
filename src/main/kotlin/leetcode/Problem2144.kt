package leetcode

/**
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
 */
class Problem2144 {
    fun minimumCost(cost: IntArray): Int {
        var answer = 0
        cost.sort()
        var i = cost.size - 1
        while (i - 1 >= 0) {
            answer += cost[i] + cost[i - 1]
            i -= 3
        }
        if (i == 0) {
            answer += cost[i]
        }
        return answer
    }
}

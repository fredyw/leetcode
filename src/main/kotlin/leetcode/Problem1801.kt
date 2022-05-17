package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/number-of-orders-in-the-backlog/
 */
class Problem1801 {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        val buyMap = TreeMap<Int, Long> { a, b -> b.compareTo(a) }
        val sellMap = TreeMap<Int, Long> { a, b -> a.compareTo(b) }
        for ((price, amount, type) in orders) {
            if (type == 0) { // buy
                var remainingAmount = amount.toLong()
                while (sellMap.isNotEmpty() && sellMap.firstKey() <= price) {
                    val count = sellMap[sellMap.firstKey()] ?: 0
                    if (count - remainingAmount <= 0) {
                        remainingAmount -= count
                        sellMap.pollFirstEntry()
                    } else {
                        sellMap[sellMap.firstKey()] = count - remainingAmount
                        remainingAmount = 0
                        break
                    }
                }
                if (remainingAmount > 0) {
                    buyMap[price] = (buyMap[price] ?: 0) + remainingAmount
                }
            } else { // sell
                var remainingAmount = amount.toLong()
                while (buyMap.isNotEmpty() && buyMap.firstKey() >= price) {
                    val count = buyMap[buyMap.firstKey()] ?: 0
                    if (count - remainingAmount <= 0) {
                        remainingAmount -= count
                        buyMap.pollFirstEntry()
                    } else {
                        buyMap[buyMap.firstKey()] = count - remainingAmount
                        remainingAmount = 0
                        break
                    }
                }
                if (remainingAmount > 0) {
                    sellMap[price] = (sellMap[price] ?: 0) + remainingAmount
                }
            }
        }
        var answer = 0L
        for ((_, count) in buyMap) {
            answer = (answer + count) % 1_000_000_007
        }
        for ((_, count) in sellMap) {
            answer = (answer + count) % 1_000_000_007
        }
        return answer.toInt()
    }
}

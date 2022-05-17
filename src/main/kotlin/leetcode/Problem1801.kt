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
                    buyMap[price] = remainingAmount
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
                    sellMap[price] = remainingAmount
                }
            }
        }
        var answer = 0L
        for ((_, count) in buyMap) {
            answer += count
        }
        for ((_, count) in sellMap) {
            answer += count
        }
        return answer.toInt() % 1_000_000_007
    }
}

fun main() {
    val prob = Problem1801()
//    println(prob.getNumberOfBacklogOrders(arrayOf(
//        intArrayOf(10,5,0), intArrayOf(15,2,1), intArrayOf(25,1,1), intArrayOf(30,4,0)
//    ))) // 6
//    println(prob.getNumberOfBacklogOrders(arrayOf(
//        intArrayOf(7,1000000000,1), intArrayOf(15,3,0), intArrayOf(5,999999995,0), intArrayOf(5,1,1)
//    ))) // 999999984
    println(prob.getNumberOfBacklogOrders(arrayOf(
        intArrayOf(1,29,1), intArrayOf(22,7,1), intArrayOf(24,1,0), intArrayOf(25,15,1),
        intArrayOf(18,8,1), intArrayOf(8,22,0), intArrayOf(25,15,1), intArrayOf(30,1,1),
        intArrayOf(27,30,0)
    ))) // 22
}
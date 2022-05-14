package leetcode

/**
 * https://leetcode.com/problems/number-of-orders-in-the-backlog/
 */
class Problem1801 {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1801()
    println(prob.getNumberOfBacklogOrders(arrayOf(
        intArrayOf(10,5,0), intArrayOf(15,2,1), intArrayOf(25,1,1), intArrayOf(30,4,0)
    ))) // 6
    println(prob.getNumberOfBacklogOrders(arrayOf(
        intArrayOf(7,1000000000,1), intArrayOf(15,3,0), intArrayOf(5,999999995,0), intArrayOf(5,1,1)
    ))) // 999999984
}
package leetcode

/**
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/
 */
class Problem2110 {
    fun getDescentPeriods(prices: IntArray): Long {
        TODO()
    }
}

fun main() {
    val prob = Problem2110()
    println(prob.getDescentPeriods(intArrayOf(3,2,1,4))) // 7
    println(prob.getDescentPeriods(intArrayOf(8,6,7,7))) // 4
    println(prob.getDescentPeriods(intArrayOf(1))) // 1
}
package leetcode

/**
 * https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/
 */
class Problem1798 {
    fun getMaximumConsecutive(coins: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1798()
    println(prob.getMaximumConsecutive(intArrayOf(1,3))) // 2
    println(prob.getMaximumConsecutive(intArrayOf(1,1,1,4))) // 8
    println(prob.getMaximumConsecutive(intArrayOf(1,4,10,3,1))) // 20
    println(prob.getMaximumConsecutive(intArrayOf(1,2,3,5))) // 12
    println(prob.getMaximumConsecutive(intArrayOf(1,1,9))) // 3
    println(prob.getMaximumConsecutive(intArrayOf(1,3,4,10))) // 2
    println(prob.getMaximumConsecutive(intArrayOf(1,1,1,10))) // 3
}
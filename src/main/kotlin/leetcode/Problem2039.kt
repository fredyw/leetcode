package leetcode

/**
 * https://leetcode.com/problems/the-time-when-the-network-becomes-idle/
 */
class Problem2039 {
    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2039()
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,2,1))) // 8
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,3,1))) // 8
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,10,1))) // 8
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,10,3))) // 8
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,10,30))) // 5
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(1,2)), intArrayOf(0,1,1))) // 8
    println(prob.networkBecomesIdle(arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2)), intArrayOf(0,10,10))) // 3
}
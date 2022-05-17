package leetcode

/**
 * https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
 */
class Problem2274 {
    fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2274()
    println(prob.maxConsecutive(2, 9, intArrayOf(4,6))) // 3
    println(prob.maxConsecutive(6, 8, intArrayOf(7,6,8))) // 0
}
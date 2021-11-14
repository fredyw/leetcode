package leetcode

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 */
class Problem2073 {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2073()
    println(prob.timeRequiredToBuy(intArrayOf(2,3,2), 2)) // 6
    println(prob.timeRequiredToBuy(intArrayOf(5,1,1,1), 0)) // 8
    println(prob.timeRequiredToBuy(intArrayOf(6,4,1,2,3), 4)) // 12
    println(prob.timeRequiredToBuy(intArrayOf(6,4,1,2,3), 3)) // 8
    println(prob.timeRequiredToBuy(intArrayOf(6,4,1,2,3), 3)) // 12
    println(prob.timeRequiredToBuy(intArrayOf(6,4,7,8,3), 4)) // 15
    println(prob.timeRequiredToBuy(intArrayOf(6,4,1,1,2,3,3), 6)) // 16
    println(prob.timeRequiredToBuy(intArrayOf(6,4,1,1,2,3,3,7), 6)) // 18
    println(prob.timeRequiredToBuy(intArrayOf(6,4,5,5,5,3,3,7), 6)) // 23
    println(prob.timeRequiredToBuy(intArrayOf(6,4,5,5,5,4,3,7), 6)) // 23
}
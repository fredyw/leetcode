package leetcode

/**
 * https://leetcode.com/problems/find-good-days-to-rob-the-bank/
 */
class Problem2100 {
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        TODO()
    }
}

fun main() {
    val prob = Problem2100()
    println(prob.goodDaysToRobBank(intArrayOf(5,3,3,3,5,6,2), 2)) // [2,3]
    println(prob.goodDaysToRobBank(intArrayOf(1,1,1,1,1), 0)) // [0,1,2,3,4]
    println(prob.goodDaysToRobBank(intArrayOf(1,2,3,4,5,6), 2)) // []
}
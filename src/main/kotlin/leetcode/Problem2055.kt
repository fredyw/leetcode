package leetcode

/**
 * https://leetcode.com/problems/plates-between-candles/
 */
class Problem2055 {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2055()
    println(prob.platesBetweenCandles("**|**|***|", arrayOf(intArrayOf(2,5), intArrayOf(5,9)))) // [2,3]
    println(prob.platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(1,17),intArrayOf(4,5),intArrayOf(14,17),intArrayOf(5,11),intArrayOf(15,16)))) // [9,0,0,0,0]
}
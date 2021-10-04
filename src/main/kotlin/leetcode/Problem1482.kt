package leetcode

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
class Problem1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1482()
    println(prob.minDays(intArrayOf(1,10,3,10,2), 3, 1)) // 3
    println(prob.minDays(intArrayOf(1,10,3,10,2), 3, 2)) // -1
    println(prob.minDays(intArrayOf(7,7,7,7,12,7,7), 2, 3)) // 12
    println(prob.minDays(intArrayOf(1000000000,1000000000), 1, 1)) // 1000000000
    println(prob.minDays(intArrayOf(1,10,2,9,3,8,4,7,5,6), 4, 2)) // 9
}
package leetcode

/**
 * https://leetcode.com/problems/smallest-index-with-equal-value/
 */
class Problem2057 {
    fun smallestEqual(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2057()
    println(prob.smallestEqual(intArrayOf(0,1,2))) // 0
    println(prob.smallestEqual(intArrayOf(4,3,2,1))) // 2
    println(prob.smallestEqual(intArrayOf(1,2,3,4,5,6,7,8,9,0))) // -1
    println(prob.smallestEqual(intArrayOf(2,1,3,5,2))) // 1
}
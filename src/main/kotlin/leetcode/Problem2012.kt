package leetcode

/**
 * https://leetcode.com/problems/sum-of-beauty-in-the-array/
 */
class Problem2012 {
    fun sumOfBeauties(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2012()
    println(prob.sumOfBeauties(intArrayOf(1,2,3))) // 2
    println(prob.sumOfBeauties(intArrayOf(2,4,6,4))) // 1
    println(prob.sumOfBeauties(intArrayOf(2,4,6,5))) // 2
    println(prob.sumOfBeauties(intArrayOf(2,4,6,6))) // 2
    println(prob.sumOfBeauties(intArrayOf(2,4,6,7))) // 4
    println(prob.sumOfBeauties(intArrayOf(2,4,6,7,8,6))) // 4
    println(prob.sumOfBeauties(intArrayOf(2,4,6,7,8,4))) // 3
    println(prob.sumOfBeauties(intArrayOf(3,2,1))) // 0
}
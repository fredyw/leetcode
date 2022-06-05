package leetcode

/**
 * https://leetcode.com/problems/replace-elements-in-an-array/
 */
class Problem2295 {
    fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2295()
    println(prob.arrayChange(
        intArrayOf(1,2,4,6),
        arrayOf(intArrayOf(1,3), intArrayOf(4,7), intArrayOf(6,1)))) // [3,2,7,1]
    println(prob.arrayChange(
        intArrayOf(1,2),
        arrayOf(intArrayOf(1,3), intArrayOf(2,1), intArrayOf(3,2)))) // [2,1]
}
package leetcode

/**
 * https://leetcode.com/problems/most-beautiful-item-for-each-query/
 */
class Problem2070 {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2070()
    println(prob.maximumBeauty(
        arrayOf(intArrayOf(1,2), intArrayOf(3,2), intArrayOf(2,4), intArrayOf(5,6), intArrayOf(3,5)),
        intArrayOf(1,2,3,4,5,6))) // [2,4,5,5,6,6]
    println(prob.maximumBeauty(
        arrayOf(intArrayOf(1,2), intArrayOf(1,2), intArrayOf(1,3), intArrayOf(1,4)),
        intArrayOf(1))) // [4]
    println(prob.maximumBeauty(arrayOf(intArrayOf(10,1000)), intArrayOf(5))) // [0]
}
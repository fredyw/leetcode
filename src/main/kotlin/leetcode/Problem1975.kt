package leetcode

/**
 * https://leetcode.com/problems/maximum-matrix-sum/
 */
class Problem1975 {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        TODO()
    }
}

fun main() {
    val prob = Problem1975()
    println(prob.maxMatrixSum(arrayOf(
        intArrayOf(1,-1),
        intArrayOf(-1,1)
    ))) // 4
    println(prob.maxMatrixSum(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(-1,-2,-3),
        intArrayOf(1,2,3)
    ))) // 16
    println(prob.maxMatrixSum(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(-1,-2,-3,4),
        intArrayOf(1,2,3,4)
    ))) // 38
    println(prob.maxMatrixSum(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(-1,-2,-3,-4),
        intArrayOf(1,2,3,4)
    ))) // 40
}
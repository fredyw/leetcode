package leetcode

/**
 * https://leetcode.com/problems/largest-magic-square/
 */
class Problem1895 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1895()
    println(prob.largestMagicSquare(arrayOf(
        intArrayOf(7,1,4,5,6),
        intArrayOf(2,5,1,6,4),
        intArrayOf(1,5,4,3,2),
        intArrayOf(1,2,7,3,4),
    ))) // 3
    println(prob.largestMagicSquare(arrayOf(
        intArrayOf(5,1,3,1),
        intArrayOf(9,3,3,1),
        intArrayOf(1,3,3,8),
    ))) // 2
}
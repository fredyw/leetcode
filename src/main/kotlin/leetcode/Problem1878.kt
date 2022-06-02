package leetcode

/**
 * https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/
 */
class Problem1878 {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem1878()
    println(prob.getBiggestThree(arrayOf(
        intArrayOf(3,4,5,1,3),
        intArrayOf(3,3,4,2,3),
        intArrayOf(20,30,200,40,10),
        intArrayOf(1,5,5,4,1),
        intArrayOf(4,3,2,2,5),
    ))) // [228,216,211]
    println(prob.getBiggestThree(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
    ))) // [20,9,8]
    println(prob.getBiggestThree(arrayOf(
        intArrayOf(7,7,7),
    ))) // [7]
}
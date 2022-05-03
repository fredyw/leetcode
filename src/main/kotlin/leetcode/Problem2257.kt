package leetcode

/**
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 */
class Problem2257 {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2257()
    println(prob.countUnguarded(4, 6,
        arrayOf(intArrayOf(0,0), intArrayOf(1,1), intArrayOf(2,3)),
        arrayOf(intArrayOf(0,1), intArrayOf(2,2), intArrayOf(1,4)))) // 7
    println(prob.countUnguarded(3, 3,
        arrayOf(intArrayOf(1,1)),
        arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(2,1), intArrayOf(1,2)))) // 4
}
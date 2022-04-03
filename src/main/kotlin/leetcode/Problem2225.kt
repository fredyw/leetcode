package leetcode

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
class Problem2225 {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        TODO()
    }
}

fun main() {
    val prob = Problem2225()
    println(prob.findWinners(arrayOf(
        intArrayOf(1,3),
        intArrayOf(2,3),
        intArrayOf(3,6),
        intArrayOf(5,6),
        intArrayOf(5,7),
        intArrayOf(4,5),
        intArrayOf(4,8),
        intArrayOf(4,9),
        intArrayOf(10,4),
        intArrayOf(10,9)))) // [[1,2,10],[4,5,7,8]]
    println(prob.findWinners(arrayOf(
        intArrayOf(2,3),
        intArrayOf(1,3),
        intArrayOf(5,4),
        intArrayOf(6,4)
    ))) // [[1,2,5,6],[]]
}
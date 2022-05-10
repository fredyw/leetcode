package leetcode

/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 */
class Problem1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        TODO()
    }
}

fun main() {
    val prob = Problem1514()
    println(
        prob.maxProbability(
            n = 3,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)),
            doubleArrayOf(0.5, 0.5, 0.2),
            start = 0,
            end = 2
        )
    ) // 0.25000
    println(
        prob.maxProbability(
            n = 3,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2)),
            doubleArrayOf(0.5, 0.5, 0.3),
            start = 0,
            end = 2
        )
    ) // 0.30000
    println(
        prob.maxProbability(
            n = 3,
            arrayOf(intArrayOf(0, 1)),
            doubleArrayOf(0.5),
            start = 0,
            end = 2
        )
    ) // 0.00000

}
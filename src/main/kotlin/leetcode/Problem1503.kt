package leetcode

/**
 * https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 */
class Problem1503 {
    fun getLastMoment(n: Int, left: IntArray?, right: IntArray?): Int {
        // TODO
        return 0
    }
}

fun main() {
    val prob = Problem1503()
    println(prob.getLastMoment(4, intArrayOf(4, 3), intArrayOf(0, 1))) // 4
    println(prob.getLastMoment(5, intArrayOf(4, 3), intArrayOf(0, 1))) // 5
    println(prob.getLastMoment(7, intArrayOf(), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7))) // 7
    println(prob.getLastMoment(7, intArrayOf(0, 1, 2, 3, 4, 5, 6, 7), intArrayOf())) // 7
    println(prob.getLastMoment(9, intArrayOf(5), intArrayOf(4))) // 5
    println(prob.getLastMoment(6, intArrayOf(6), intArrayOf(0))) // 6
}
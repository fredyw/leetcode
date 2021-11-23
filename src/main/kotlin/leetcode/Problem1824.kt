package leetcode

/**
 * https://leetcode.com/problems/minimum-sideway-jumps/
 */
class Problem1824 {
    fun minSideJumps(obstacles: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1824()
    println(prob.minSideJumps(intArrayOf(0,1,2,3,0))) // 2
    println(prob.minSideJumps(intArrayOf(0,1,1,3,3,0))) // 0
    println(prob.minSideJumps(intArrayOf(0,2,1,0,3,0))) // 2
}
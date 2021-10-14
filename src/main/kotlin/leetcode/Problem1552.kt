package leetcode

/**
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 */
class Problem1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1552()
    println(prob.maxDistance(intArrayOf(1,2,3,4,7), 3)) // 3
    println(prob.maxDistance(intArrayOf(5,4,3,2,1,1000000000), 2)) // 999999999
    println(prob.maxDistance(intArrayOf(5,4,3,2,1,1000000000), 3)) // 4
    println(prob.maxDistance(intArrayOf(5,4,3,2,1,1000000000), 4)) // 2
}
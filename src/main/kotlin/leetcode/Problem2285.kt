package leetcode

/**
 * https://leetcode.com/problems/maximum-total-importance-of-roads/
 */
class Problem2285 {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        TODO()
    }
}

fun main() {
    val prob = Problem2285()
    println(prob.maximumImportance(5, arrayOf(
        intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,3), intArrayOf(0,2),
        intArrayOf(1,3), intArrayOf(2,4)
    ))) // 43
    println(prob.maximumImportance(5, arrayOf(
        intArrayOf(0,3), intArrayOf(2,4), intArrayOf(1,3)
    ))) // 20
}
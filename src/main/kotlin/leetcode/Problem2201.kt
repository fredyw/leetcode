package leetcode

/**
 * https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
 */
class Problem2201 {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2201()
    println(prob.digArtifacts(
        2,
        arrayOf(intArrayOf(0,0,0,0), intArrayOf(0,1,1,1)),
        arrayOf(intArrayOf(0,0), intArrayOf(0,1))
    )) // 1
    println(prob.digArtifacts(
        2,
        arrayOf(intArrayOf(0,0,0,0), intArrayOf(0,1,1,1)),
        arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,1))
    )) // 2
}
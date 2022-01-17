package leetcode

/**
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 */
class Problem1673 {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem1673()
    println(prob.mostCompetitive(intArrayOf(3,5,2,6), 2)) // [2,6]
    println(prob.mostCompetitive(intArrayOf(2,4,3,3,5,4,9,6), 4)) // [2,3,3,4]
    println(prob.mostCompetitive(intArrayOf(4,3,3,5,4,9,6,2), 4)) // [3,3,4,2]
}
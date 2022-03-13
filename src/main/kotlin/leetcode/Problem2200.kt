package leetcode

/**
 * https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 */
class Problem2200 {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        TODO()
    }
}

fun main() {
    val prob = Problem2200()
    println(prob.findKDistantIndices(intArrayOf(3,4,9,1,3,9,5), 9, 1)) // [1,2,3,4,5,6]
    println(prob.findKDistantIndices(intArrayOf(2,2,2,2,2), 2, 2)) // [0,1,2,3,4]
}
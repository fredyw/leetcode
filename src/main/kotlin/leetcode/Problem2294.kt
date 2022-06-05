package leetcode

/**
 * https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
 */
class Problem2294 {
    fun partitionArray(nums: IntArray, k: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2294()
    println(prob.partitionArray(intArrayOf(3,6,1,2,5), 2)) // 2
    println(prob.partitionArray(intArrayOf(1,2,3), 1)) // 2
    println(prob.partitionArray(intArrayOf(2,2,4,5), 0)) // 3
}
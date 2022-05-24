package leetcode

/**
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 */
class Problem2279 {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2279()
    println(prob.maximumBags(intArrayOf(2,3,4,5), intArrayOf(1,2,4,4), 2)) // 3
    println(prob.maximumBags(intArrayOf(10,2,2), intArrayOf(2,2,0), 100)) // 3
}
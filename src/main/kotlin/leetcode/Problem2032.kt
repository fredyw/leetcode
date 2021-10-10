package leetcode

/**
 * https://leetcode.com/problems/two-out-of-three/
 */
class Problem2032 {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        TODO()
    }
}

fun main() {
    val prob = Problem2032()
    println(prob.twoOutOfThree(intArrayOf(1,1,3,2), intArrayOf(2,3), intArrayOf(3))) // [3,2]
    println(prob.twoOutOfThree(intArrayOf(3,1), intArrayOf(2,3), intArrayOf(1,2))) // [2,3,1]
    println(prob.twoOutOfThree(intArrayOf(1,2,2), intArrayOf(4,3,3), intArrayOf(5))) // []
}
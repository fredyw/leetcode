package leetcode

/**
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
 */
class Problem2091 {
    fun minimumDeletions(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2091()
    println(prob.minimumDeletions(intArrayOf(2,10,7,5,4,1,8,6))) // 5
    println(prob.minimumDeletions(intArrayOf(0,-4,19,1,8,-2,-3,5))) // 3
    println(prob.minimumDeletions(intArrayOf(101))) // -1
}
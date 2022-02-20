package leetcode

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
class Problem2134 {
    fun minSwaps(nums: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2134()
    println(prob.minSwaps(intArrayOf(0,1,0,1,1,0,0))) // 1
    println(prob.minSwaps(intArrayOf(0,1,1,1,0,0,1,1,0))) // 2
    println(prob.minSwaps(intArrayOf(1,1,0,0,1))) // 0
    println(prob.minSwaps(intArrayOf(0,1,0,1,0,1,0,1,0,1))) // 2

}
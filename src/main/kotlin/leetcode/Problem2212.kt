package leetcode

/**
 * https://leetcode.com/problems/maximum-points-in-an-archery-competition/
 */
class Problem2212 {
    fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2212()
    println(prob.maximumBobPoints(9, intArrayOf(1,1,0,1,0,0,2,1,0,1,2,0))) // [0,0,0,0,1,1,0,0,1,2,3,1]
    println(prob.maximumBobPoints(3, intArrayOf(0,0,1,0,0,0,0,0,0,0,0,2))) // [0,0,0,0,0,0,0,0,1,1,1,0]
}
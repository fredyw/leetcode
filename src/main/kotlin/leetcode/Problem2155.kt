package leetcode

class Problem2155 {
    fun maxScoreIndices(nums: IntArray): List<Int> {
        TODO()
    }
}

fun main() {
    val prob = Problem2155()
    println(prob.maxScoreIndices(intArrayOf(0,0,1,0))) // [2,4]
    println(prob.maxScoreIndices(intArrayOf(0,0,0))) // [3]
    println(prob.maxScoreIndices(intArrayOf(1,1))) // [0]
}
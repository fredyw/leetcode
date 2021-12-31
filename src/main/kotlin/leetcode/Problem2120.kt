package leetcode

/**
 * https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
 */
class Problem2120 {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2120()
    println(prob.executeInstructions(3, intArrayOf(0,1), "RRDDLU")) // [1,5,4,3,1,0]
    println(prob.executeInstructions(2, intArrayOf(1,1), "LURD")) // [4,1,0,0]
    println(prob.executeInstructions(1, intArrayOf(0,0), "LRUD")) // [0,0,0,0]
}
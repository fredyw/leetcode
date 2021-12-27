package leetcode

/**
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 */
class Problem2109 {
    fun addSpaces(s: String, spaces: IntArray): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2109()
    println(prob.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8,13,15))) // "Leetcode Helps Me Learn"
    println(prob.addSpaces("icodeinpython", intArrayOf(1,5,7,9))) // "i code in py thon"
    println(prob.addSpaces("spacing", intArrayOf(0,1,2,3,4,5,6))) // " s p a c i n g"
}
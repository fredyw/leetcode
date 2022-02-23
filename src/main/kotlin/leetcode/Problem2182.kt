package leetcode

/**
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 */
class Problem2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2182()
    println(prob.repeatLimitedString("cczazcc", 3)) // "zzcccac"
    println(prob.repeatLimitedString("aababab", 2)) // "bbabaa"
}
package leetcode

/**
 * https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/
 */
class Problem2232 {
    fun minimizeResult(expression: String): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2232()
    println(prob.minimizeResult("247+38")) // "2(47+38)"
    println(prob.minimizeResult("12+348")) // "1(2+3)4"
    println(prob.minimizeResult("999+999")) // "(999+999)"
}
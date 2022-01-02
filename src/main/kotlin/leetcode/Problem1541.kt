package leetcode

/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 */
class Problem1541 {
    fun minInsertions(s: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1541()
    println(prob.minInsertions("(()))")) // 1
    println(prob.minInsertions("())")) // 0
    println(prob.minInsertions("))())(")) // 3
}

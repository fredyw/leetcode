package leetcode

/**
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 */
class Problem2287 {
    fun rearrangeCharacters(s: String, target: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2287()
    println(prob.rearrangeCharacters("ilovecodingonleetcode", "code")) // 2
    println(prob.rearrangeCharacters("abcba", "abc")) // 1
    println(prob.rearrangeCharacters("abbaccaddaeea", "aaaaa")) // 1
}
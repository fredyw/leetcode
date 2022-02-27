package leetcode

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */
class Problem2185 {
    fun prefixCount(words: Array<String>, pref: String): Int {
        return words.count { it.startsWith(pref) }
    }
}

fun main() {
    val prob = Problem2185()
    println(prob.prefixCount(arrayOf("pay","attention","practice","attend"), "at")) // 2
    println(prob.prefixCount(arrayOf("leetcode","win","loops","success"), "code")) // 0
}
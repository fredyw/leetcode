package leetcode

/**
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/
 */
class Problem2255 {
    fun countPrefixes(words: Array<String>, s: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2255()
    println(prob.countPrefixes(arrayOf("a","b","c","ab","bc","abc"), "abc")) // 3
    println(prob.countPrefixes(arrayOf("a","a"), "aa")) // 2
}
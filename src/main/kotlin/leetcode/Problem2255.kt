package leetcode

/**
 * https://leetcode.com/problems/count-prefixes-of-a-given-string/
 */
class Problem2255 {
    fun countPrefixes(words: Array<String>, s: String): Int {
        return words.count { s.startsWith(it) }
    }
}

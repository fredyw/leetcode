package leetcode

/**
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */
class Problem2185 {
    fun prefixCount(words: Array<String>, pref: String): Int {
        return words.count { it.startsWith(pref) }
    }
}

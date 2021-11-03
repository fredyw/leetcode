package leetcode

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 */
class Problem1930 {
    fun countPalindromicSubsequence(s: String): Int {
        val lastIndexMap = mutableMapOf<Char, Int>()
        for ((index, char) in s.withIndex()) {
            lastIndexMap[char] = index
        }
        val charMap = mutableMapOf<Char, MutableSet<Char>>()
        for ((index, char) in s.withIndex()) {
            for (c in charMap.keys) {
                if (index < lastIndexMap[c]!!) {
                    val chars = charMap[c]
                    if (chars != null) {
                        chars += char
                    }
                }
            }
            val chars = charMap[char]
            if (chars == null) {
                charMap[char] = mutableSetOf()
            }
        }
        return charMap.values.map { it.size }.fold(0) {sum, size -> sum + size }
    }
}

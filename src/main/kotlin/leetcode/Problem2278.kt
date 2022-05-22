package leetcode

/**
 * https://leetcode.com/problems/percentage-of-letter-in-string/
 */
class Problem2278 {
    fun percentageLetter(s: String, letter: Char): Int {
        val chars = IntArray(26)
        for (c in s) {
            chars[c - 'a']++
        }
        if (chars[letter - 'a'] == 0) {
            return 0
        }
        return (chars[letter - 'a'].toDouble() / s.length.toDouble() * 100).toInt()
    }
}

package leetcode

import kotlin.math.abs

/**
 * https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
 */
class Problem2068 {
    fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
        val charToCount1 = IntArray(26)
        val charToCount2 = IntArray(26)
        for (i in word1.indices) {
            charToCount1[word1[i] - 'a']++
            charToCount2[word2[i] - 'a']++
        }
        for (i in 0 until 26) {
            if (abs(charToCount1[i] - charToCount2[i]) > 3) {
                return false
            }
        }
        return true
    }
}

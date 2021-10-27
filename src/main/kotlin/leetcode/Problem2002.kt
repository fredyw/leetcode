package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 */
class Problem2002 {
    fun maxProduct(s: String): Int {
        return maxProduct(s, 0, "", "")
    }

    private fun maxProduct(s: String, i: Int, word1: String, word2: String): Int {
        if (s.length == i) {
            if (isPalindrome(word1) && isPalindrome(word2)) {
                return word1.length * word2.length
            }
            return 1
        }
        val a = maxProduct(s, i + 1, word1 + s[i], word2)
        val b = maxProduct(s, i + 1, word1, word2 + s[i])
        val c = maxProduct(s, i + 1, word1, word2)
        return max(a, max(b, c))
    }

    private fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}

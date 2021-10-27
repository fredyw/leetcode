package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 */
class Problem2002 {
    fun maxProduct(s: String): Int {
        return longestPalindrome(s,
            i = 0,
            j = s.length - 1,
            memo = Array(s.length) { IntArray(s.length) { -1 } })
    }

    private fun longestPalindrome(s: String, i: Int, j: Int, memo: Array<IntArray>): Int {
        if (i > j) {
            return 0
        }
        if (i == j) {
            return 1
        }
        if (memo[i][j] != -1) {
            return memo[i][j]
        }
        val max = if (s[i] == s[j]) {
            2 + longestPalindrome(s, i + 1, j - 1, memo)
        } else {
            max(
                longestPalindrome(s, i + 1, j, memo),
                longestPalindrome(s, i, j - 1, memo)
            )
        }
        memo[i][j] = max
        return max
    }
}

fun main() {
    val prob = Problem2002()
    println(prob.maxProduct("leetcodecom")) // 9
    println(prob.maxProduct("bb")) // 1
    println(prob.maxProduct("accbcaxxcxx")) // 25
    println(prob.maxProduct("abcba")) // 6
    println(prob.maxProduct("aaa")) // 2
}
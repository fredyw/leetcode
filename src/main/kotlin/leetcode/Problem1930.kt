package leetcode

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 */
class Problem1930 {
    fun countPalindromicSubsequence(s: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1930()
    println(prob.countPalindromicSubsequence("aabca")) // 3
    println(prob.countPalindromicSubsequence("adc")) // 0
    println(prob.countPalindromicSubsequence("bbcbaba")) // 4
    println(prob.countPalindromicSubsequence("aabbcabbc")) // 8
    println(prob.countPalindromicSubsequence("aabbcabbcb")) // 8
    println(prob.countPalindromicSubsequence("aabbccabbc")) // 9
    println(prob.countPalindromicSubsequence("aabaabaacb")) // 5
}
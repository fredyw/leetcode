package leetcode

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 */
class Problem2108 {
    fun firstPalindrome(words: Array<String>): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2108()
    println(prob.firstPalindrome(arrayOf("abc","car","ada","racecar","cool"))) // "ada"
    println(prob.firstPalindrome(arrayOf("notapalindrome","racecar"))) // "racecar"
    println(prob.firstPalindrome(arrayOf("def","ghi"))) // ""
}
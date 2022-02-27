package leetcode

/**
 * https://leetcode.com/problems/next-greater-numerically-balanced-number/
 */
class Problem2048 {
    fun nextBeautifulNumber(n: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2048()
    println(prob.nextBeautifulNumber(1)) // 22
    println(prob.nextBeautifulNumber(1000)) // 1333
    println(prob.nextBeautifulNumber(3000)) // 3133
    println(prob.nextBeautifulNumber(22)) // 122
    println(prob.nextBeautifulNumber(20)) // 22
}
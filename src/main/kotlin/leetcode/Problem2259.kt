package leetcode

/**
 * https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
 */
class Problem2259 {
    fun removeDigit(number: String, digit: Char): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2259()
    println(prob.removeDigit("123", '3')) // "12"
    println(prob.removeDigit("1231", '1')) // "231"
    println(prob.removeDigit("551", '5')) // "51"
}
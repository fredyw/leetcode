package leetcode

/**
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
 */
class Problem2047 {
    fun countValidWords(sentence: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2047()
    println(prob.countValidWords("cat and  dog")) // 3
    println(prob.countValidWords("!this  1-s b8d!")) // 0
    println(prob.countValidWords("alice and  bob are playing stone-game10")) // 5
    println(prob.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.")) // 6
}
package leetcode

/**
 * https://leetcode.com/problems/vowels-of-all-substrings/
 */
class Problem2063 {
    fun countVowels(word: String): Long {
        TODO()
    }

    private fun isVowel(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u'
    }
}

fun main() {
    val prob = Problem2063()
    println(prob.countVowels("aba")) // 6
    println(prob.countVowels("abc")) // 3
    println(prob.countVowels("ltcd")) // 0
    println(prob.countVowels("noosabasboosa")) // 237
    println(prob.countVowels("bac")) // 4
}
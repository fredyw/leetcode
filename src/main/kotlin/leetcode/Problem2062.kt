package leetcode

/**
 * https://leetcode.com/problems/count-vowel-substrings-of-a-string/
 */
class Problem2062 {
    fun countVowelSubstrings(word: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2062()
    println(prob.countVowelSubstrings("aeiouu")) // 2
    println(prob.countVowelSubstrings("unicornarihan")) // 0
    println(prob.countVowelSubstrings("cuaieuouac")) // 7
    println(prob.countVowelSubstrings("bbaeixoubb")) // 0
}
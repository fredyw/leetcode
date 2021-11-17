package leetcode

/**
 * https://leetcode.com/problems/vowels-of-all-substrings/
 */
class Problem2063 {
    fun countVowels(word: String): Long {
        var answer = 0L
        for (i in word.indices) {
            if (isVowel(word[i])) {
                answer += (i.toLong() + 1) * (word.length - i)
            }
        }
        return answer
    }

    private fun isVowel(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u'
    }
}

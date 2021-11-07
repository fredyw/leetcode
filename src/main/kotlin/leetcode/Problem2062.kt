package leetcode

/**
 * https://leetcode.com/problems/count-vowel-substrings-of-a-string/
 */
class Problem2062 {
    fun countVowelSubstrings(word: String): Int {
        var answer = 0
        for (i in word.indices) {
            var vowels = mutableSetOf<Char>()
            for (j in i until word.length) {
                if (isVowel(word[j])) {
                    vowels.add(word[j])
                    if (vowels.size == 5) {
                        answer++
                    }
                } else {
                    break
                }
            }
        }
        return answer
    }

    private fun isVowel(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u'
    }
}

package leetcode

/**
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
 */
class Problem2047 {
    fun countValidWords(sentence: String): Int {
        var answer = 0
        val words = sentence.split("""\s+""".toRegex())
        val regex = """(?:[a-z]+(?:-[a-z]+|[a-z]+)?)?[!.,]?""".toRegex()
        for (word in words) {
            if (word.trim().isNotEmpty() && regex.matches(word)) {
                answer++
            }
        }
        return answer
    }
}

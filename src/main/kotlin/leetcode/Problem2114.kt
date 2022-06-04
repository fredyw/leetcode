package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */
class Problem2114 {
    fun mostWordsFound(sentences: Array<String>): Int {
        var answer = 0
        for (sentence in sentences) {
            answer = max(answer, sentence.split(" ").size)
        }
        return answer
    }
}

package leetcode

import java.util.LinkedList
import kotlin.math.max

/**
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 */
class Problem2024 {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        return max(consecutiveAnswers(answerKey, k, 'T'), consecutiveAnswers(answerKey, k, 'F'))
    }

    private fun consecutiveAnswers(answerKey: String, k: Int, c: Char): Int {
        var max = 0
        var indexes = LinkedList<Int>()
        var count = k
        var length = 0
        for (i in answerKey.indices) {
            if (answerKey[i] == c) {
                if (count - 1 < 0) {
                    count++
                    length = if (indexes.isEmpty()) {
                        0
                    } else {
                        i - indexes.pollFirst() - 1
                    }
                }
                count--
                indexes.add(i)
            }
            length++
            max = max(max, length)
        }
        return max
    }
}

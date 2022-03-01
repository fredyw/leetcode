package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/next-greater-numerically-balanced-number/
 */
class Problem2048 {
    fun nextBeautifulNumber(n: Int): Int {
        var answer = Answer()
        val s = n.toString()
        val numbers = arrayOf("1", "22", "122", "333", "1333", "4444", "14444", "22333",
            "55555", "122333", "155555", "224444", "666666")
        for (num in numbers) {
            if (s.length > num.length) {
                continue
            }
            permutations(num.toCharArray(), n = n, answer = answer)
        }
        return answer.value
    }

    private data class Answer(var value: Int = 1224444 /* maximum possible */)

    private fun permutations(chars: CharArray, index: Int = 0, n: Int, answer: Answer) {
        if (index == chars.size) {
            val next = String(chars).toInt()
            if (next > n) {
                answer.value = min(answer.value, next)
            }
        }
        for (i in index until chars.size) {
            val tmp1 = chars[i]
            val tmp2 = chars[index]
            chars[i] = tmp2
            chars[index] = tmp1
            permutations(chars, index + 1, n, answer)
            chars[i] = tmp1
            chars[index] = tmp2
        }
    }
}

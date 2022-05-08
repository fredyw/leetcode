package leetcode

/**
 * https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
 */
class Problem2259 {
    fun removeDigit(number: String, digit: Char): String {
        var answer = ""
        for (i in number.indices) {
            if (digit != number[i]) {
                continue
            }
            val s = when (i) {
                0 -> {
                    number.substring(i + 1)
                }
                number.length - 1 -> {
                    number.substring(0, i)
                }
                else -> {
                    number.substring(0, i) + number.substring(i + 1)
                }
            }
            if (answer < s) {
                answer = s
            }
        }
        return answer
    }
}

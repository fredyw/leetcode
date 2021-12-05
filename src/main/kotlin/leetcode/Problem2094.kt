package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers/
 */
class Problem2094 {
    fun findEvenNumbers(digits: IntArray): IntArray {
        val answer = TreeSet<Int>()
        for (i in digits.indices) {
            if (digits[i] == 0) {
                continue
            }
            for (j in digits.indices) {
                if (i == j) {
                    continue
                }
                for (k in digits.indices) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue
                    }
                    answer += ("" + digits[i] + digits[j] + digits[k]).toInt()
                }
            }
        }
        return answer.toIntArray()
    }
}

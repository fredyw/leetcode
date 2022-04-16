package leetcode

/**
 * https://leetcode.com/problems/find-good-days-to-rob-the-bank/
 */
class Problem2100 {
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        if (time == 0) {
            return security.mapIndexed { i, _ -> i }
        }
        val left = IntArray(security.size)
        for (i in security.indices) {
            if (i == 0 || security[i] > security[i - 1]) {
                left[i] = 1
            } else {
                left[i] = left[i - 1] + 1
            }
        }
        val right = IntArray(security.size)
        for (i in security.size - 1 downTo 0) {
            if (i == security.size - 1 || security[i] > security[i + 1]) {
                right[i] = 1
            } else {
                right[i] = right[i + 1] + 1
            }
        }
        val answer = mutableListOf<Int>()
        for (i in security.indices) {
            if (left[i] >= time + 1 && right[i] >= time + 1) {
                answer += i
            }
        }
        return answer
    }
}

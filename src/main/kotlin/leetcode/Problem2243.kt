package leetcode

/**
 * https://leetcode.com/problems/calculate-digit-sum-of-a-string/
 */
class Problem2243 {
    fun digitSum(s: String, k: Int): String {
        var answer = s
        while (answer.length > k) {
            var i = 0
            var tmp = answer
            answer = ""
            while (i < tmp.length) {
                val group = if (i + k > tmp.length) {
                    tmp.substring(i)
                } else {
                    tmp.substring(i, i + k)
                }
                answer += sum(group).toString()
                i += k
            }
        }
        return answer
    }

    private fun sum(s: String): Int {
        var sum = 0
        for (c in s) {
            sum += c - '0'
        }
        return sum
    }
}

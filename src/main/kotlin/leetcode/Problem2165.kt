package leetcode

/**
 * https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
 */
class Problem2165 {
    fun smallestNumber(num: Long): Long {
        if (num > 0) {
            val chars = num.toString().toCharArray()
            chars.sort()
            var count = 0
            var i = 0
            while (chars[i] == '0') {
                i++
                count++
            }
            var answer = chars[i++] + "0".repeat(count)
            while (i < chars.size) {
                answer += chars[i++]
            }
            return answer.toLong()
        } else if (num < 0) {
            val chars = num.toString().substring(1).toCharArray()
            chars.sortDescending()
            val answer = String(chars)
            return -1 * answer.toLong()
        }
        return 0
    }
}

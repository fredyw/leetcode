package leetcode

/**
 * https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 */
class Problem2269 {
    fun divisorSubstrings(num: Int, k: Int): Int {
        var answer = 0
        val s = num.toString()
        var i = 0
        while (i + k <= s.length) {
            val n = s.substring(i, i + k).toInt()
            if (n != 0 && num % n == 0) {
                answer++
            }
            i++
        }
        return answer
    }
}

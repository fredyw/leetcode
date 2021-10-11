package leetcode

/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */
class Problem1680 {
    fun concatenatedBinary(n: Int): Int {
        var answer = 0L
        for (i in 1..n) {
            answer = if (i == 1) {
                1
            } else {
                (i + (answer shl bitSize(i))) % 1_000_000_007
            }
        }
        return answer.toInt()
    }

    private fun bitSize(n: Int): Int {
        var length = 0
        var i = n
        while (i > 0) {
            i = i shr 1
            length++
        }
        return length
    }
}

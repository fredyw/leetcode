package leetcode

/**
 * https://leetcode.com/problems/count-integers-with-even-digit-sum/
 */
class Problem2180 {
    fun countEven(num: Int): Int {
        val s = num.toString()
        var sum = 0
        for (c in s) {
            sum += c.toInt()
        }
        return if (sum % 2 == 0) num / 2 else (num - 1) / 2
    }
}

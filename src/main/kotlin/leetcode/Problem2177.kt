package leetcode

/**
 * https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
 */
class Problem2177 {
    fun sumOfThree(num: Long): LongArray {
        val b = num / 3
        val a = b - 1
        val c = b + 1
        if (a + b + c == num) {
            return longArrayOf(a, b, c)
        }
        return longArrayOf()
    }
}

package leetcode

/**
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 */
class Problem2160 {
    fun minimumSum(num: Int): Int {
        val chars = num.toString().toCharArray()
        chars.sort()
        return "${chars[0]}${chars[2]}".toInt() + "${chars[1]}${chars[3]}".toInt()
    }
}

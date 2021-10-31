package leetcode

/**
 * https://leetcode.com/problems/smallest-index-with-equal-value/
 */
class Problem2057 {
    fun smallestEqual(nums: IntArray): Int {
        for ((index, num) in nums.withIndex()) {
            if (index % 10 == num) {
                return index
            }
        }
        return -1
    }
}

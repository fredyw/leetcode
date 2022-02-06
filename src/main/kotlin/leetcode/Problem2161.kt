package leetcode

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/
 */
class Problem2161 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val left = mutableListOf<Int>()
        val center = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (num in nums) {
            if (num < pivot) {
                left += num
            } else if (num == pivot) {
                center += num
            } else {
                right += num
            }
        }
        left += center
        left += right
        return left.toIntArray()
    }
}

package leetcode

/**
 * https://leetcode.com/problems/replace-elements-in-an-array/
 */
class Problem2295 {
    fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
        val map = mutableMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            map[num] = index
        }
        for ((from, to) in operations) {
            val index = map[from]
            if (index != null) {
                nums[index] = to
                map[to] = index
            }
        }
        return nums
    }
}

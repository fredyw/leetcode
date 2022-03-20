package leetcode

/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs/
 */
class Problem2206 {
    fun divideArray(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            val count = (map[num] ?: 0) + 1
            map[num] = count
        }
        for (count in map.values) {
            if (count % 2 != 0) {
                return false
            }
        }
        return true
    }
}

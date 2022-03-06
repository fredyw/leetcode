package leetcode

/**
 * https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
 */
class Problem2190 {
    fun mostFrequent(nums: IntArray, key: Int): Int {
        var answer = 0
        var maxCount = 0
        val map = mutableMapOf<Int, Int>()
        for (i in 0..(nums.size - 2)) {
            if (nums[i] == key) {
                val count = (map[nums[i + 1]] ?: 0) + 1
                map[nums[i + 1]] = count
                if (count > maxCount) {
                    maxCount = count
                    answer = nums[i + 1]
                }
            }
        }
        return answer
    }
}

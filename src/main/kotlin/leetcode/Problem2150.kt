package leetcode

/**
 * https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
 */
class Problem2150 {
    fun findLonely(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }
        val answer = mutableListOf<Int>()
        for ((key, value) in map) {
            if (value > 1) {
                continue
            }
            if (key + 1 in map || key - 1 in map) {
                continue
            }
            answer += key
        }
        return answer
    }
}

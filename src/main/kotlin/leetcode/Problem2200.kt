package leetcode

/**
 * https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
 */
class Problem2200 {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val answer = mutableSetOf<Int>()
        for (i in nums.indices) {
            if (nums[i] == key) {
                var j = if (i - k < 0) 0 else i - k
                while (j < nums.size && j <= i + k) {
                    answer += j
                    j++
                }
            }
        }
        return answer.toList()
    }
}

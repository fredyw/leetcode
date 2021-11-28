package leetcode

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */
class Problem2089 {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()
        val answer = mutableListOf<Int>()
        for ((index, num) in nums.withIndex()) {
            if (num == target) {
                answer += index
            }
        }
        return answer
    }
}

package leetcode

/**
 * https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
 */
class Problem2294 {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var answer = 0
        var i = nums.size - 1
        while (i >= 0) {
            var index = nums.binarySearch(nums[i] - k, 0, i + 1)
            if (index < 0) {
                index = -index - 1
            }
            var j = index - 1
            while (j >= 0 && nums[j] == nums[index]) {
                j--
            }
            i = j
            answer++
        }
        return answer
    }
}

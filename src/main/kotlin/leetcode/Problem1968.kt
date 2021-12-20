package leetcode

/**
 * https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
 */
class Problem1968 {
    fun rearrangeArray(nums: IntArray): IntArray {
        nums.sort()
        val mid = nums.size / 2
        val answer = IntArray(nums.size)
        var i = 0
        var j = 0
        while (i <= mid && j < nums.size) {
            answer[j] = nums[i]
            i++
            j += 2
        }
        i = if (nums.size % 2 == 0) mid else mid + 1
        j = 1
        while (i < nums.size && j < nums.size) {
            answer[j] = nums[i]
            i++
            j += 2
        }
        return answer
    }
}

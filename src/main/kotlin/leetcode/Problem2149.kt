package leetcode

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */
class Problem2149 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        val positives = IntArray(nums.size / 2)
        val negatives = IntArray(nums.size / 2)
        var pi = 0
        var ni = 0
        for (num in nums) {
            if (num < 0) {
                negatives[ni++] = num
            } else {
                positives[pi++] = num
            }
        }
        var i = 0
        pi = 0
        ni = 0
        while (i < nums.size) {
            if (i % 2 == 0) {
                answer[i] = positives[pi++]
            } else {
                answer[i] = negatives[ni++]
            }
            i++
        }
        return answer
    }
}

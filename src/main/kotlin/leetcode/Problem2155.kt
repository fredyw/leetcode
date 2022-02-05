package leetcode

class Problem2155 {
    fun maxScoreIndices(nums: IntArray): List<Int> {
        var left = IntArray(nums.size)
        var count = 0
        for (i in 0 until nums.size) {
            if (nums[i] == 0) {
                count++
            }
            left[i] = count
        }
        var right = IntArray(nums.size)
        count = 0
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] == 1) {
                count++
            }
            right[i] = count
        }
        val answer = mutableListOf<Int>()
        var max = 0
        for (i in 0 until nums.size) {
            val score = (if (i - 1 < 0) 0 else left[i - 1]) + right[i]
            if (score > max) {
                max = score
                answer.clear()
                answer += i
            } else if (score == max) {
                answer += i
            }
        }
        val score = left[nums.size - 1]
        if (score > max) {
            max = score
            answer.clear()
            answer += nums.size
        } else if (score == max) {
            answer += nums.size
        }
        return answer
    }
}

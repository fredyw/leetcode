package leetcode

/**
 * https://leetcode.com/problems/sort-even-and-odd-indices-independently/
 */
class Problem2164 {
    fun sortEvenOdd(nums: IntArray): IntArray {
        val odd = mutableListOf<Int>()
        val even = mutableListOf<Int>()
        for (i in nums.indices) {
            if (i % 2 == 0) {
                even += nums[i]
            } else {
                odd += nums[i]
            }
        }
        odd.sortDescending()
        even.sort()
        val answer = IntArray(nums.size)
        var oddIndex = 0
        var evenIndex = 0
        for (i in nums.indices) {
            answer[i] = if (i % 2 == 0) even[evenIndex++] else odd[oddIndex++]
        }
        return answer
    }
}

package leetcode

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 */
class Problem2210 {
    fun countHillValley(nums: IntArray): Int {
        val list = mutableListOf<Int>()
        for (i in nums.indices) {
            list += if (i == 0) {
                nums[i]
            } else {
                if (nums[i - 1] == nums[i]) {
                    continue
                } else {
                    nums[i]
                }
            }
        }
        if (list.size < 3) {
            return 0
        }
        var answer = 0
        for (i in 1..list.size - 2) {
            if ((list[i] < list[i - 1] && list[i] < list[i + 1]) ||
                (list[i] > list[i - 1] && list[i] > list[i + 1])) {
                answer++
            }
        }
        return answer
    }
}

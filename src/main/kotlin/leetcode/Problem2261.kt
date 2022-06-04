package leetcode

/**
 * https://leetcode.com/problems/k-divisible-elements-subarrays/
 */
class Problem2261 {
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        val set = mutableSetOf<String>()
        for (i in nums.indices) {
            var count = 0
            var j = i
            var str = ""
            while (j < nums.size) {
                if (nums[j] % p == 0) {
                    count++
                }
                if (count > k) {
                    break
                }
                str += nums[j].toString() + ","
                set += str
                j++
            }
        }
        return set.size
    }
}

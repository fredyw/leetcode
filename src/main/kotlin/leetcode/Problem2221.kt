package leetcode

/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 */
class Problem2221 {
    fun triangularSum(nums: IntArray): Int {
        var list = mutableListOf<Int>()
        list.addAll(nums.toList())
        while (list.size > 1) {
            var tmp = mutableListOf<Int>()
            for (i in 0 until list.size - 1) {
                tmp.add((list[i] + list[i + 1]) % 10)
            }
            list = tmp
        }
        return list[0]
    }
}

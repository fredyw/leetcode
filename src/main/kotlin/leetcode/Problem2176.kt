package leetcode

/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 */
class Problem2176 {
    fun countPairs(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (i in nums.indices) {
            val list = map[nums[i]] ?: mutableListOf()
            list += i
            map[nums[i]] = list
        }
        var answer = 0
        for (indexes in map.values) {
           for (i in 0 until indexes.size) {
               for (j in i + 1 until indexes.size) {
                   if ((indexes[i] * indexes[j]) % k == 0) {
                       answer++
                   }
               }
           }
        }
        return answer
    }
}

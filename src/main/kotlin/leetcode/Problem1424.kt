package leetcode

import java.util.TreeMap

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
class Problem1424 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val map = TreeMap<Int, List<Int>>()
        for ((row, num) in nums.withIndex()) {
            for ((col, n) in num.withIndex()) {
                map[row + col] = (map[row + col] ?: listOf()) + n
            }
        }
        val answer = mutableListOf<Int>()
        for (list in map.values) {
           for (num in list.asReversed()) {
               answer += num
           }
        }
        return answer.toIntArray()
    }
}

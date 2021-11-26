package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
class Problem1424 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val maxRow = nums.size
        var maxCol = 0
        for (num in nums) {
            maxCol = max(maxCol, num.size)
        }
        val answer = mutableListOf<Int>()
        for (row in 0 until maxRow) {
            var r = row
            var c = 0
            while (r >= 0) {
                if (c < nums[r].size) {
                    answer += nums[r][c]
                }
                r--
                c++
            }
        }
        for (col in 1 until maxCol) {
            var r = maxRow - 1
            var c = col
            while (r >= 0) {
                if (c < nums[r].size) {
                    answer += nums[r][c]
                }
                r--
                c++
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    val prob = Problem1424()
    println(prob.findDiagonalOrder(listOf(
        listOf(1,2,3),
        listOf(4,5,6),
        listOf(7,8,9))).contentToString()) // [1,4,2,7,5,3,8,6,9]
    println(prob.findDiagonalOrder(listOf(
        listOf(1,2,3,4,5),
        listOf(6,7),
        listOf(8),
        listOf(9,10,11),
        listOf(12,13,14,15,16))).contentToString()) // [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
    println(prob.findDiagonalOrder(listOf(
        listOf(1,2,3),
        listOf(4),
        listOf(5,6,7),
        listOf(8),
        listOf(9,10,11))).contentToString()) // [1,4,2,5,3,8,6,9,7,10,11]
    println(prob.findDiagonalOrder(listOf(
        listOf(1,2,3,4,5,6))).contentToString()) // [1,2,3,4,5,6]
}
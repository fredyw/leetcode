package leetcode

import kotlin.math.abs

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
 */
class Problem2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val array = IntArray(grid.size * grid[0].size)
        var index = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                array[index++] = grid[i][j]
            }
        }
        array.sort()
        val median = array[array.size / 2]
        var answer = 0
        for (i in array) {
            val diff = abs(i - median)
            if (diff % x != 0) {
                return -1
            }
            answer += diff / x
        }
        return answer
    }
}

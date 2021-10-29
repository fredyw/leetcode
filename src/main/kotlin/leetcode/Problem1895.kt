package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/largest-magic-square/
 */
class Problem1895 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        val maxRow = grid.size
        val maxCol = if (maxRow > 0) grid[0].size else 0
        val rowSums = Array(maxRow) { IntArray(maxCol) }
        val colSums = Array(maxRow) { IntArray(maxCol) }
        val rightDiagonalSums =  Array(maxRow) { IntArray(maxCol) }
        val leftDiagonalSums =  Array(maxRow) { IntArray(maxCol) }
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                // Direction: --
                rowSums[row][col] = if (col == 0) {
                    grid[row][col]
                } else {
                    rowSums[row][col - 1] + grid[row][col]
                }
                // Direction: |
                colSums[row][col] = if (row == 0) {
                    grid[row][col]
                } else {
                    colSums[row - 1][col] + grid[row][col]
                }
                // Direction: \
                rightDiagonalSums[row][col] = if (row == 0 || col == 0) {
                    grid[row][col]
                } else {
                    rightDiagonalSums[row - 1][col - 1] + grid[row][col]
                }
                // Direction: /
                leftDiagonalSums[row][col] = if (row == 0 || col == maxCol - 1) {
                    grid[row][col]
                } else {
                    leftDiagonalSums[row - 1][col + 1] + grid[row][col]
                }
            }
        }
        var answer = 1
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                var k = 1
                while (row + k <= maxRow && col + k <= maxCol) {
                    if (isMagicSquare(rowSums, colSums, leftDiagonalSums, rightDiagonalSums,
                            row, col, k)) {
                        answer = max(answer, k)
                    }
                    k++
                }
            }
        }
        return answer
    }

    private fun isMagicSquare(rowSums: Array<IntArray>,
                              colSums: Array<IntArray>,
                              leftDiagonalSums: Array<IntArray>,
                              rightDiagonalSums: Array<IntArray>,
                              row: Int, col: Int, size: Int): Boolean {
        val maxRow = rowSums.size
        val maxCol = if (maxRow > 0) rowSums[0].size else 0
        var sum = 0
        for (r in row until row + size) {
            val rowSum = rowSums[r][col + size - 1] - (if (col - 1 >= 0) rowSums[r][col - 1] else 0)
            if (sum == 0) {
                sum = rowSum
            } else {
                if (sum != rowSum) {
                    return false
                }
            }
        }
        for (c in col until col + size) {
            val colSum = colSums[row + size - 1][c] - (if (row - 1 >= 0) colSums[row - 1][c] else 0)
            if (sum != colSum) {
                return false
            }
        }
        val rightDiagonalSum = rightDiagonalSums[row + size - 1][col + size - 1] -
                (if (row - 1 >= 0 && col - 1 >= 0) rightDiagonalSums[row - 1][col - 1] else 0)
        if (sum != rightDiagonalSum) {
            return false
        }
        val leftDiagonalSum = leftDiagonalSums[row + size - 1][col] -
                (if (row - 1 >= 0 && col + size < maxCol) leftDiagonalSums[row - 1][col + size] else 0)
        if (sum != leftDiagonalSum) {
            return false
        }
        return true
    }
}

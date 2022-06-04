package leetcode

import java.util.TreeSet

/**
 * https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/
 */
class Problem1878 {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val rightDiagonalSums = mutableMapOf<RowCol, Int>()
        val maxRow = grid.size
        val maxCol = if (maxRow > 0) grid[0].size else 0
        for (row in 0 until maxRow) {
            rightDiagonalSums(grid, rightDiagonalSums, row, 0)
        }
        for (col in 0 until maxCol) {
            rightDiagonalSums(grid, rightDiagonalSums, 0, col)
        }
        val leftDiagonalSums = mutableMapOf<RowCol, Int>()
        for (row in 0 until maxRow) {
            leftDiagonalSums(grid, leftDiagonalSums, row, maxCol - 1)
        }
        for (col in maxCol - 1 downTo 0) {
            leftDiagonalSums(grid, leftDiagonalSums, 0, col)
        }
        val set = TreeSet<Int>()
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                set += rhombusSum(grid, leftDiagonalSums, rightDiagonalSums, row, col)
            }
        }
        var list = mutableListOf<Int>()
        var i = 0
        while (set.isNotEmpty() && i < 3) {
            list.add(set.pollLast())
            i++
        }
        return list.toIntArray()
    }

    private data class RowCol(val row: Int, val col: Int)

    private fun rightDiagonalSums(grid: Array<IntArray>,
                                  rightDiagonalSums: MutableMap<RowCol, Int>,
                                  row: Int, col: Int) {
        val maxRow = grid.size
        val maxCol = if (maxRow > 0) grid[0].size else 0
        var r = row
        var c = col
        while (r < maxRow && c < maxCol) {
            rightDiagonalSums[RowCol(r, c)] = if (rightDiagonalSums[RowCol(r - 1, c - 1)] == null) {
                grid[r][c]
            } else {
                rightDiagonalSums[RowCol(r - 1, c - 1)]!! + grid[r][c]
            }
            r++
            c++
        }
    }

    private fun leftDiagonalSums(grid: Array<IntArray>,
                                 leftDiagonalSums: MutableMap<RowCol, Int>,
                                 row: Int, col: Int) {
        val maxRow = grid.size
        var r = row
        var c = col
        while (r < maxRow && c >= 0) {
            leftDiagonalSums[RowCol(r, c)] = if (leftDiagonalSums[RowCol(r - 1, c + 1)] == null) {
                grid[r][c]
            } else {
                leftDiagonalSums[RowCol(r - 1, c + 1)]!! + grid[r][c]
            }
            r++
            c--
        }
    }

    private fun rhombusSum(grid: Array<IntArray>,
                           leftDiagonalSums: MutableMap<RowCol, Int>,
                           rightDiagonalSums: MutableMap<RowCol, Int>,
                           row: Int, col: Int): MutableSet<Int> {
        val set = mutableSetOf(grid[row][col])
        val maxRow = grid.size
        val maxCol = if (maxRow > 0) grid[0].size else 0
        var r = row
        val c = col
        var length = 1
        while (r + (length * 2) < maxRow && c - length >= 0 && c + length < maxCol) {
            val topLeft = leftDiagonalSums[RowCol(r + length, c - length)]!! -
                    leftDiagonalSums[RowCol(r, c)]!! + grid[r][c]
            val topRight = rightDiagonalSums[RowCol(r + length, c + length)]!! -
                    rightDiagonalSums[RowCol(r, c)]!! + grid[r][c]
            val bottomLeft = rightDiagonalSums[RowCol(r + length * 2, c)]!! -
                    rightDiagonalSums[RowCol(r + length, c - length)]!! +
                    grid[r + length][c - length]
            val bottomRight = leftDiagonalSums[RowCol(r + length * 2, c)]!! -
                    leftDiagonalSums[RowCol(r + length, c + length)]!! +
                    grid[r + length][c + length]
            val sum = topLeft + topRight + bottomLeft + bottomRight -
                    (grid[r][c] + grid[r + length][c - length] +
                            grid[r + length][c + length] + grid[r + length * 2][c])
            set += sum
            length++
        }
        return set
    }
}

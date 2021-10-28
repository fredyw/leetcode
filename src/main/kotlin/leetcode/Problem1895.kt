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
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                rowSums[row][col] = if (col == 0) {
                    grid[row][col]
                } else {
                    rowSums[row][col - 1] + grid[row][col]
                }
            }
        }
        val colSums = Array(maxRow) { IntArray(maxCol) }
        for (col in 0 until maxCol) {
            for (row in 0 until maxRow) {
                colSums[row][col] = if (row == 0) {
                    grid[row][col]
                } else {
                    colSums[row - 1][col] + grid[row][col]
                }
            }
        }
        val rightDiagonalSums =  Array(maxRow) { IntArray(maxCol) }
        for (row in 0 until maxRow) {
            var r = row
            var c = 0
            while (r < maxRow && c < maxCol) {
                rightDiagonalSums[r][c] = if (c == 0) {
                    grid[r][c]
                } else {
                    rightDiagonalSums[r - 1][c - 1] + grid[r][c]
                }
                r++
                c++
            }
        }
        for (col in 0 until maxCol) {
            var r = 0
            var c = col
            while (r < maxRow && c < maxCol) {
                rightDiagonalSums[r][c] = if (r == 0) {
                    grid[r][c]
                } else {
                    rightDiagonalSums[r - 1][c - 1] + grid[r][c]
                }
                r++
                c++
            }
        }
        val leftDiagonalSums =  Array(maxRow) { IntArray(maxCol) }
        for (row in maxRow - 1 downTo 0) {
            var r = row
            var c = maxCol - 1
            while (r < maxRow && c >= 0) {
                leftDiagonalSums[r][c] = if (c == maxCol - 1) {
                    grid[r][c]
                } else {
                    leftDiagonalSums[r - 1][c + 1] + grid[r][c]
                }
                r++
                c--
            }
        }
        for (col in maxCol - 1 downTo 0) {
            var r = 0
            var c = col
            while (r < maxRow && c >= 0) {
                leftDiagonalSums[r][c] = if (r == 0) {
                    grid[r][c]
                } else {
                    leftDiagonalSums[r - 1][c + 1] + grid[r][c]
                }
                r++
                c--
            }
        }
        var answer = 1
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                var r = row
                var c = col
                var k = 1
                while (r < maxRow && c < maxCol) {
                    if (isMagicSquare(rowSums, colSums, leftDiagonalSums, rightDiagonalSums, r, c, k)) {
                        answer = max(answer, k)
                    }
                    k++
                    r++
                    c++
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
        TODO()
    }
}

fun main() {
    val prob = Problem1895()
    println(prob.largestMagicSquare(arrayOf(
        intArrayOf(7,1,4,5,6),
        intArrayOf(2,5,1,6,4),
        intArrayOf(1,5,4,3,2),
        intArrayOf(1,2,7,3,4),
    ))) // 3
//    println(prob.largestMagicSquare(arrayOf(
//        intArrayOf(5,1,3,1),
//        intArrayOf(9,3,3,1),
//        intArrayOf(1,3,3,8),
//    ))) // 2
}
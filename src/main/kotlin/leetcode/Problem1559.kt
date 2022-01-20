package leetcode

/**
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */
class Problem1559 {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val maxRow = grid.size
        val maxCol = if (maxRow == 0) 0 else grid[0].size
        val visited = Array(grid.size) { BooleanArray(maxCol) }
        var row = 0
        while (row < maxRow) {
            var col = 0
            while (col < maxCol) {
                if (visited[row][col]) {
                    col++
                    continue
                }
                if (containsCycle(grid, maxRow, maxCol, grid[row][col], visited, -1, -1, row, col)) {
                    return true
                }
                col++
            }
            row++
        }
        return false
    }

    private fun containsCycle(grid: Array<CharArray>, maxRow: Int, maxCol: Int, char: Char,
                              visited: Array<BooleanArray>, previousRow: Int, previousCol: Int,
                              currentRow: Int, currentCol: Int): Boolean {

        if (visited[currentRow][currentCol]) {
            return false
        }
        visited[currentRow][currentCol] = true
        for ((r, c) in arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))) {
            val newRow = currentRow + r
            val newCol = currentCol + c
            if (newRow < 0 || newRow == maxRow || newCol < 0 || newCol == maxCol) {
                continue
            }
            if (grid[newRow][newCol] != char) {
                continue
            }
            if (!(previousRow == newRow && previousCol == newCol)) {
                if (visited[newRow][newCol]) {
                    return true
                }
                if (containsCycle(
                        grid, maxRow, maxCol, char, visited, currentRow, currentCol,
                        newRow, newCol
                    )
                ) {
                    return true
                }
            }
        }
        return false
    }
}

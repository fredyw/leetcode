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
                val counts = Array(grid.size) { IntArray(maxCol) }
                if (containsCycle(grid, maxRow, maxCol, grid[row][col], visited, counts, row, col, 1)) {
                    return true
                }
                col++
            }
            row++
        }
        return false
    }

    private fun containsCycle(grid: Array<CharArray>, maxRow: Int, maxCol: Int, char: Char,
                              visited: Array<BooleanArray>, counts: Array<IntArray>,
                              row: Int, col: Int, count: Int): Boolean {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return false
        }
        if (grid[row][col] != char) {
            return false
        }
        if (visited[row][col]) {
            if (count - counts[row][col] >= 4) {
                return true
            }
            return false
        }
        visited[row][col] = true
        counts[row][col] = count
        val up = containsCycle(grid, maxRow, maxCol, char, visited, counts, row - 1, col, count + 1)
        val right = containsCycle(grid, maxRow, maxCol, char, visited, counts, row, col + 1, count + 1)
        val down = containsCycle(grid, maxRow, maxCol, char, visited, counts, row + 1, col, count + 1)
        val left = containsCycle(grid, maxRow, maxCol, char, visited, counts, row, col - 1, count + 1)
        return up || right || down || left
    }
}

fun main() {
    val prob = Problem1559()
    println(prob.containsCycle(arrayOf(
        charArrayOf('a','a','a','a'),
        charArrayOf('a','b','b','a'),
        charArrayOf('a','b','b','a'),
        charArrayOf('a','a','a','a')))) // true
    println(prob.containsCycle(arrayOf(
        charArrayOf('c','c','c','a'),
        charArrayOf('c','d','c','c'),
        charArrayOf('c','c','e','c'),
        charArrayOf('f','c','c','c')))) // true
    println(prob.containsCycle(arrayOf(
        charArrayOf('a','b','b'),
        charArrayOf('b','z','b'),
        charArrayOf('b','b','a')))) // false
    println(prob.containsCycle(arrayOf(
        charArrayOf('f','c','b','d','f','a','e','e','a','c','e'),
        charArrayOf('d','f','f','c','c','a','b','b','a','c','f'),
        charArrayOf('e','d','d','a','d','d','d','c','f','b','e'),
        charArrayOf('e','a','d','d','a','e','e','a','c','f','b'),
        charArrayOf('d','c','f','a','b','c','c','d','e','c','b'),
        charArrayOf('d','a','e','d','a','a','a','e','f','a','b'),
        charArrayOf('d','f','e','a','f','b','c','b','d','a','e'),
        charArrayOf('c','f','d','c','d','a','e','e','a','a','e'),
        charArrayOf('f','b','c','e','e','b','e','b','a','a','a'),
        charArrayOf('d','d','b','c','b','f','a','c','b','c','d'),
        charArrayOf('e','e','c','c','e','b','e','f','b','c','d')))) // true
}
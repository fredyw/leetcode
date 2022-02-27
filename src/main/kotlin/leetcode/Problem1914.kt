package leetcode

/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid/
 */
class Problem1914 {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val maxRows: Int = grid.size
        val maxCols: Int = if (grid.isNotEmpty()) grid[0].size else 0
        var row = 0
        var col = 0
        var length = 0
        var height = maxRows
        var width = maxCols
        while (height >= 2 && width >= 2) {
            val perimeter = 2 * (height + width)
            rotateGrid(grid, maxRows, maxCols, length++, row++, col++, k % (perimeter - 4))
            height -= 2
            width -= 2
        }
        return grid
    }

    private fun rotateGrid(grid: Array<IntArray>, maxRows: Int, maxCols: Int, length: Int,
                           row: Int, col: Int, k: Int) {
        var elements = mutableListOf<Int>()
        iterate(maxRows, maxCols, length, row, col) { r, c ->
            elements.add(grid[r][c])
        }
        var index = 0
        var start = false
        var n = 0
        for (i in 0 until elements.size + k) {
            iterate(maxRows, maxCols, length, row, col) { r, c ->
                if (n++ == k) {
                    start = true
                }
                if (start && index < elements.size) {
                    grid[r][c] = elements[index++]
                }
            }
        }
    }

    private fun iterate(maxRows: Int, maxCols: Int, length: Int, row: Int, col: Int,
                        f: (Int, Int) -> Unit) {
        // Go down.
        var r = row
        var c = col
        while (r < maxRows - length) {
            f(r, c)
            r++
        }
        // Go left.
        r--
        c++
        while (c < maxCols - length) {
            f(r, c)
            c++
        }
        // Go up.
        r--
        c--
        while (r >= length) {
            f(r, c)
            r--
        }
        // Go right.
        c--
        r++
        while (c >= length + 1) {
            f(r, c)
            c--
        }
    }
}

package leetcode

/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid/
 */
class Problem1914 {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val maxRows = grid.size
        val maxCols = if (grid.isNotEmpty()) grid[0].size else 0
        var row = 0
        var col = 0
        var length = 0
        while (maxRows - (length * 2) >= 2 && maxCols - (length * 2) >= 2) {
            rotateGrid(grid, maxRows, maxCols, length, row++, col++,
                k % ((maxRows - (length * 2)) * (maxCols - (length * 2))))
            length++
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
        for (i in 1..maxRows + maxCols + k) {
            iterate(maxRows, maxCols, length, row, col) { r, c ->
                if (n == k) {
                    start = true
                }
                if (start && index < elements.size) {
                    grid[r][c] = elements[index++]
                }
                n++
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


fun main() {
    val prob = Problem1914()
    println(prob.rotateGrid(arrayOf(
        intArrayOf(40,10),
        intArrayOf(30,20)), 1).contentDeepToString()) // [[10,20],[40,30]]
    println(prob.rotateGrid(arrayOf(
        intArrayOf(40,10),
        intArrayOf(30,20)), 3).contentDeepToString()) // [[30,40],[20,10]]
    println(prob.rotateGrid(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16)), 2).contentDeepToString()) // [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
    println(prob.rotateGrid(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16)), 5).contentDeepToString()) // [[12,16,15,14],[8,7,11,13],[4,6,10,9],[3,2,1,5]]
    println(prob.rotateGrid(arrayOf(
        intArrayOf(10,1,4,8),
        intArrayOf(6,6,3,10),
        intArrayOf(7,4,7,10),
        intArrayOf(1,10,6,1),
        intArrayOf(2,1,1,10),
        intArrayOf(3,8,9,2),
        intArrayOf(7,1,10,10),
        intArrayOf(7,1,4,9),
        intArrayOf(2,2,4,2),
        intArrayOf(10,7,5,10)), 1).contentDeepToString()) // [[1,4,8,10],[10,3,7,10],[6,6,6,1],[7,4,1,10],[1,10,9,2],[2,1,10,10],[3,8,4,9],[7,1,4,2],[7,1,2,10],[2,10,7,5]]
    println(prob.rotateGrid(arrayOf(
        intArrayOf(7,8,8,10,4,7,2,8),
        intArrayOf(4,8,9,9,1,5,9,4),
        intArrayOf(8,9,4,8,9,9,1,5),
        intArrayOf(1,2,7,8,10,1,1,10),
        intArrayOf(7,6,6,8,2,5,5,4),
        intArrayOf(7,7,3,3,6,10,10,6),
        intArrayOf(2,5,2,9,3,9,10,2),
        intArrayOf(7,5,8,1,3,3,4,7)), 3).contentDeepToString()) // [[10,4,7,2,8,4,5,10],[8,1,5,9,1,1,5,4],[8,9,9,1,5,10,10,6],[7,9,9,8,8,6,10,2],[4,8,8,2,10,3,9,7],[8,9,4,7,6,3,3,4],[1,2,6,7,5,2,9,3],[7,7,2,7,5,8,1,3]]
}
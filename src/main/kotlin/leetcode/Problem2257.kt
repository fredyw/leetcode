package leetcode

/**
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 */
class Problem2257 {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val grid = Array(m) { IntArray(n) { UNGUARDED } }
        for ((r, c) in guards) {
            grid[r][c] = GUARD
        }
        for ((r, c) in walls) {
            grid[r][c] = WALL
        }
        for ((r, c) in guards) {
            // Up
            var i = r - 1
            while (i >= 0 && (grid[i][c] != WALL && grid[i][c] != GUARD)) {
                grid[i][c] = GUARDED
                i--
            }
            // Right
            i = c + 1
            while (i < n && (grid[r][i] != WALL && grid[r][i] != GUARD)) {
                grid[r][i] = GUARDED
                i++
            }
            // Down
            i = r + 1
            while (i < m && (grid[i][c] != WALL && grid[i][c] != GUARD)) {
                grid[i][c] = GUARDED
                i++
            }
            // Left
            i = c - 1
            while (i >= 0 && (grid[r][i] != WALL && grid[r][i] != GUARD)) {
                grid[r][i] = GUARDED
                i--
            }
        }
        var answer = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == UNGUARDED) {
                    answer++
                }
            }
        }
        return answer
    }

    companion object {
        private const val GUARD = 1
        private const val WALL = 2
        private const val GUARDED = 3
        private const val UNGUARDED = 4
    }
}

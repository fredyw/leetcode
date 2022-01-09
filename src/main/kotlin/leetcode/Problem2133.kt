package leetcode

/**
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
 */
class Problem2133 {
    fun checkValid(matrix: Array<IntArray>): Boolean {
        val n = matrix.size
        for (row in matrix.indices) {
            val rowSet = mutableSetOf<Int>()
            val colSet = mutableSetOf<Int>()
            for (col in matrix[row].indices) {
                rowSet += matrix[row][col]
                colSet += matrix[col][row]
            }
            if (rowSet.size != n || colSet.size != n) {
                return false
            }
        }
        return true
    }
}

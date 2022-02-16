package leetcode

/**
 * https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/
 */
class Problem2018 {
    fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
        val maxRow = board.size
        val maxCol = if (maxRow > 0) board[0].size else 0
        for (row in 0 until maxRow) {
            for (col in 0 until maxCol) {
                if (board[row][col] == '#') {
                    continue
                }
                if (canPlace(board, word, row, col)) {
                    return true
                }
            }
        }
        return false
    }

    private fun canPlace(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        if (canPlaceDown(board, word, row, col)) {
            return true
        }
        if (canPlaceRight(board, word, row, col)) {
            return true
        }
        if (canPlaceUp(board, word, row, col)) {
            return true
        }
        if (canPlaceLeft(board, word, row, col)) {
            return true
        }
        return false
    }

    private fun canPlaceDown(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        val maxRow = board.size
        if ((row - 1 < 0 || board[row - 1][col] == '#')
            && row + word.length <= maxRow
            && (row + word.length == maxRow || board[row + word.length][col] == '#')) {
            var r = row
            var i = 0
            while (i < word.length) {
                if (board[r][col] == '#') {
                    return false
                }
                if (board[r][col] in 'a'..'z' && board[r][col] != word[i]) {
                    return false
                }
                r++
                i++
            }
            return true
        }
        return false
    }

    private fun canPlaceRight(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        val maxCol = if (board.size > 0) board[0].size else 0
        if ((col - 1 < 0 || board[row][col - 1] == '#')
            && col + word.length <= maxCol
            && (col + word.length == maxCol || board[row][col + word.length] == '#')) {
            var c = col
            var i = 0
            while (i < word.length) {
                if (board[row][c] == '#') {
                    return false
                }
                if (board[row][c] in 'a'..'z' && board[row][c] != word[i]) {
                    return false
                }
                c++
                i++
            }
            return true
        }
        return false
    }

    private fun canPlaceUp(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        val maxRow = board.size
        if ((row + 1 == maxRow || board[row + 1][col] == '#')
            && row - word.length >= -1
            && (row - word.length == -1 || board[row - word.length][col] == '#')) {
            var r = row
            var i = 0
            while (i < word.length) {
                if (board[r][col] == '#') {
                    return false
                }
                if (board[r][col] in 'a'..'z' && board[r][col] != word[i]) {
                    return false
                }
                r--
                i++
            }
            return true
        }
        return false
    }

    private fun canPlaceLeft(board: Array<CharArray>, word: String, row: Int, col: Int): Boolean {
        val maxCol = if (board.size > 0) board[0].size else 0
        if ((col + 1 == maxCol || board[row][col + 1] == '#')
            && col - word.length >= -1
            && (col - word.length == -1 || board[row][col - word.length] == '#')) {
            var c = col
            var i = 0
            while (i < word.length) {
                if (board[row][c] == '#') {
                    return false
                }
                if (board[row][c] in 'a'..'z' && board[row][c] != word[i]) {
                    return false
                }
                c--
                i++
            }
            return true
        }
        return false
    }
}

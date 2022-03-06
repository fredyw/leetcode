package leetcode

/**
 * https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
 */
class Problem2194 {
    fun cellsInRange(s: String): List<String> {
        val answer = mutableListOf<String>()
        val (from, to) = s.split(":")
        for (col in from[0]..to[0]) {
            for (row in from[1].toInt()..to[1].toInt()) {
                answer += "$col${row.toChar()}"
            }
        }
        return answer
    }
}

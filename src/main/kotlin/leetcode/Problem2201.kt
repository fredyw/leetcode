package leetcode

/**
 * https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
 */
class Problem2201 {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        data class Cell(val row: Int, val col: Int)
        val digs = mutableSetOf<Cell>()
        for (d in dig) {
            digs += Cell(d[0], d[1])
        }
        var answer = 0
        for (artifact in artifacts) {
            val r1 = artifact[0]
            val c1 = artifact[1]
            val r2 = artifact[2]
            val c2 = artifact[3]
            var found = true
            outer@ for (r in r1..r2) {
                for (c in c1..c2) {
                    if (Cell(r, c) !in digs) {
                        found = false
                        break@outer
                    }
                }
            }
            if (found) {
                answer++
            }
        }
        return answer
    }
}

package leetcode

/**
 * https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/
 */
class Problem2087 {
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
        var answer = 0
        if (startPos[0] < homePos[0]) {
            var row = startPos[0] + 1
            while (row <= homePos[0]) {
                answer += rowCosts[row]
                row++
            }
        } else if (startPos[0] > homePos[0]) {
            var row = startPos[0] - 1
            while (row >= homePos[0]) {
                answer += rowCosts[row]
                row--
            }
        }
        if (startPos[1] < homePos[1]) {
            var col = startPos[1] + 1
            while (col <= homePos[1]) {
                answer += colCosts[col]
                col++
            }
        } else if (startPos[1] > homePos[1]) {
            var col = startPos[1] - 1
            while (col >= homePos[1]) {
                answer += colCosts[col]
                col--
            }
        }
        return answer
    }
}

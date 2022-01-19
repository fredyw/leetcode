package leetcode

/**
 * https://leetcode.com/problems/minimum-moves-to-reach-target-score/
 */
class Problem2139 {
    fun minMoves(target: Int, maxDoubles: Int): Int {
        var moves = 0
        var n = target
        var d = maxDoubles
        while (n > 1 && d > 0) {
            if (n % 2 != 0) {
                moves += 2
            } else {
                moves++
            }
            n /= 2
            d--
        }
        return moves + n - 1
    }
}

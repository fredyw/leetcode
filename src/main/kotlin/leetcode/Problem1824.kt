package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-sideway-jumps/
 */
class Problem1824 {
    fun minSideJumps(obstacles: IntArray): Int {
        return minSideJumps(obstacles, lane = 2, index = 0,
            memo = Array(obstacles.size) { IntArray(4) { -1 } })
    }

    private fun minSideJumps(obstacles: IntArray, lane: Int, index: Int, memo: Array<IntArray>): Int {
        if (obstacles.size == index) {
            return 0
        }
        if (obstacles[index] == lane) {
            return Int.MAX_VALUE
        }
        if (memo[index][lane] != -1) {
            return memo[index][lane]
        }
        val noSideJump = minSideJumps(obstacles, lane, index + 1, memo)
        var hasSideJump = Int.MAX_VALUE
        for (l in 1..3) {
            if (l == lane || obstacles[index] == l) {
                continue
            }
            var sideJump = minSideJumps(obstacles, l, index + 1, memo)
            if (sideJump != Int.MAX_VALUE) {
                sideJump++
            }
            hasSideJump = min(hasSideJump, sideJump)
        }
        val min = min(noSideJump, hasSideJump)
        memo[index][lane] = min
        return min
    }
}

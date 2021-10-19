package leetcode

/**
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 */
class Problem1552 {
    fun maxDistance(position: IntArray, m: Int): Int {
        position.sort()
        var answer = 0
        var lo = 1
        var hi = position[position.size - 1]
        while (lo <= hi) {
            val mid = lo + (hi - lo) / 2
            if (canApplyForce(position, m, mid)) {
                lo = mid + 1
                answer = mid
            } else {
                hi = mid - 1
            }
        }
        return answer
    }

    private fun canApplyForce(positions: IntArray, m: Int, value: Int): Boolean {
        var count = m - 1
        var prevPosition = positions[0]
        for (i in 1 until positions.size) {
            if (positions[i] - prevPosition >= value) {
                prevPosition = positions[i]
                count--
            }
            if (count == 0) {
                return true
            }
        }
        return false
    }
}

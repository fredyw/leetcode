package leetcode

import kotlin.math.abs

/**
 * https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 */
class Problem2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        var answer = 0
        seats.sort()
        students.sort()
        for (i in seats.indices) {
            answer += abs(seats[i] - students[i])
        }
        return answer
    }
}

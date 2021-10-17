package leetcode

/**
 * https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 */
class Problem2037 {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2037()
    println(prob.minMovesToSeat(intArrayOf(3,1,5), intArrayOf(2,7,4))) // 4
    println(prob.minMovesToSeat(intArrayOf(4,1,5,9), intArrayOf(1,3,2,6))) // 7
    println(prob.minMovesToSeat(intArrayOf(2,2,6,6), intArrayOf(1,3,2,6))) // 4
}
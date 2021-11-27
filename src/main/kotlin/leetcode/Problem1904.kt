package leetcode

/**
 * https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
 */
class Problem1904 {
    fun numberOfRounds(startTime: String, finishTime: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem1904()
    println(prob.numberOfRounds("12:01", "12:44")) // 1
    println(prob.numberOfRounds("20:00", "06:00")) // 40
    println(prob.numberOfRounds("00:00", "23:59")) // 95
}
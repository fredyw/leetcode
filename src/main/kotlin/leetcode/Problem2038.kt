package leetcode

/**
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 */
class Problem2038 {
    fun winnerOfGame(colors: String): Boolean {
        TODO()
    }
}

fun main() {
    val prob = Problem2038()
    println(prob.winnerOfGame("AAABABB")) // true
    println(prob.winnerOfGame("AA")) // false
    println(prob.winnerOfGame("ABBBBBBBAAA")) // false
}
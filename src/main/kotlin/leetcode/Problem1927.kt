package leetcode

/**
 * https://leetcode.com/problems/sum-game/
 */
class Problem1927 {
    fun sumGame(num: String): Boolean {
        TODO()
    }
}

fun main() {
    val prob = Problem1927()
    println(prob.sumGame("5023")) // false
    println(prob.sumGame("25??")) // true
    println(prob.sumGame("?3295???")) // false
}
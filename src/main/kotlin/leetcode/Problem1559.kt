package leetcode

/**
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */
class Problem1559 {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        TODO()
    }
}

fun main() {
    val prob = Problem1559()
    println(prob.containsCycle(arrayOf(
        charArrayOf('a','a','a','a'),
        charArrayOf('a','b','b','a'),
        charArrayOf('a','b','b','a'),
        charArrayOf('a','a','a','a')))) // true
    println(prob.containsCycle(arrayOf(
        charArrayOf('c','c','c','a'),
        charArrayOf('c','d','c','c'),
        charArrayOf('c','c','e','c'),
        charArrayOf('f','c','c','c')))) // true
    println(prob.containsCycle(arrayOf(
        charArrayOf('a','b','b'),
        charArrayOf('b','z','b'),
        charArrayOf('b','b','a')))) // false
}
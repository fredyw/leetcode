package leetcode

/**
 * https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/
 */
class Problem2018 {
    fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
        TODO()
    }
}

fun main() {
    val prob = Problem2018()
    println(prob.placeWordInCrossword(arrayOf(
        charArrayOf('#', ' ', '#'),
        charArrayOf(' ', ' ', '#'),
        charArrayOf('#', 'c', ' ')), "abc")) // true
    println(prob.placeWordInCrossword(arrayOf(
        charArrayOf(' ', '#', 'a'),
        charArrayOf(' ', '#', 'c'),
        charArrayOf(' ', '#', 'a')), "abc")) // false
    println(prob.placeWordInCrossword(arrayOf(
        charArrayOf('#', ' ', '#'),
        charArrayOf(' ', ' ', '#'),
        charArrayOf('#', ' ', 'c')), "ca")) // true
}
package leetcode

/**
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 */
class Problem2144 {
    fun mostWordsFound(sentences: Array<String>): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2144()
    println(prob.mostWordsFound(arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much"))) // 6
    println(prob.mostWordsFound(arrayOf("please wait", "continue to fight", "continue to win"))) // 3
}
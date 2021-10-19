package leetcode

/**
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 */
class Problem2024 {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2024()
    println(prob.maxConsecutiveAnswers("TTFF", 2)) // 4
    println(prob.maxConsecutiveAnswers("TFFT", 1)) // 3
    println(prob.maxConsecutiveAnswers("TTFTTFTT", 1)) // 5
}
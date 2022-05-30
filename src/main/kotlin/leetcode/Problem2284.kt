package leetcode

/**
 * https://leetcode.com/problems/sender-with-largest-word-count/
 */
class Problem2284 {
    fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2284()
    println(prob.largestWordCount(
        arrayOf("Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"),
        arrayOf("Alice","userTwo","userThree","Alice")
    )) // "Alice"
    println(prob.largestWordCount(
        arrayOf(["How is leetcode for everyone","Leetcode is useful for practice"),
        arrayOf("Bob","Charlie")
    )) // "Charlie"
}
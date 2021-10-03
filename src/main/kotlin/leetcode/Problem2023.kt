package leetcode

/**
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */
class Problem2023 {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        // TODO
        return 0;
    }
}

fun main() {
    val prob = Problem2023()
    println(prob.numOfPairs(arrayOf("777", "7", "77", "77"), "7777")) // 4
    println(prob.numOfPairs(arrayOf("123", "4", "12", "34"), "1234")) // 2
    println(prob.numOfPairs(arrayOf("1", "1", "1"), "11")) // 6
}
package leetcode

/**
 * https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
 */
class Problem2042 {
    fun areNumbersAscending(s: String): Boolean {
        val words = s.split(" ")
        var number = 0
        for (word in words) {
            val num = word.toIntOrNull()
            if (num != null) {
                if (number >= num) {
                    return false
                }
                number = num
            }
        }
        return true
    }
}

package leetcode

/**
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */
class Problem2023 {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        var answer = 0
        for ((index1, num1) in nums.withIndex()) {
            for ((index2, num2) in nums.withIndex()) {
                if (index1 == index2) {
                    continue
                }
                if (num1 + num2 == target) {
                    answer++
                }
            }
        }
        return answer
    }
}

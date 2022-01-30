package leetcode

/**
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 */
class Problem2154 {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        val set = nums.toSet()
        var answer = original
        while (answer in set) {
            answer *= 2
        }
        return answer
    }
}

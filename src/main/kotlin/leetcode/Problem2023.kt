package leetcode

/**
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */
class Problem2023 {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        var answer = 0
        val map = mutableMapOf<String, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }
        for (num in nums) {
            if (num.length >= target.length) {
                continue
            }
            if (target.endsWith(num)) {
                val prefix = target.substring(0, target.length - num.length)
                answer += map[prefix] ?: 0
                if (prefix in map && num == prefix) {
                    answer--
                }
            }
            if (target.startsWith(num)) {
                val suffix = target.substring(num.length)
                answer += map[suffix] ?: 0
                if (suffix in map && num == suffix) {
                    answer--
                }
            }
        }
        return answer / 2
    }
}

package leetcode

/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 */
class Problem2248 {
    fun intersection(nums: Array<IntArray>): List<Int> {
        var intersection = setOf<Int>()
        for (num in nums) {
            val set = num.toSet()
            intersection = if (intersection.isEmpty()) {
                set
            } else {
                intersection.intersect(set)
            }
        }
        return intersection.toList().sorted()
    }
}

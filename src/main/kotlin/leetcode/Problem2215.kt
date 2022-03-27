package leetcode

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */
class Problem2215 {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val answer1 = mutableSetOf<Int>()
        for (num in nums1) {
            if (num !in set2) {
                answer1 += num
            }
        }
        val answer2 = mutableSetOf<Int>()
        for (num in nums2) {
            if (num !in set1) {
                answer2 += num
            }
        }
        answer += answer1.toList()
        answer += answer2.toList()
        return answer
    }
}

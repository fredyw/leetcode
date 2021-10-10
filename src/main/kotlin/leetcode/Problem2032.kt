package leetcode

/**
 * https://leetcode.com/problems/two-out-of-three/
 */
class Problem2032 {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val set1 = mutableSetOf<Int>()
        nums1.forEach {
            if (it !in set1) {
                set1 += it
            }
        }
        val set2 = mutableSetOf<Int>()
        nums2.forEach {
            if (it !in set2) {
                set2 += it
            }
        }
        val set3 = mutableSetOf<Int>()
        nums3.forEach {
            if (it !in set3) {
                set3 += it
            }
        }
        val map = mutableMapOf<Int, Int>()
        set1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        set2.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        set3.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        val answer = mutableListOf<Int>()
        map.forEach {
            if (it.value >= 2) {
                answer += it.key
            }
        }
        return answer
    }
}

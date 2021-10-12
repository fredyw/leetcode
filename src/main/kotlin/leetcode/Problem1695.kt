package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 */
class Problem1695 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var answer = 0
        val map = mutableMapOf<Int, Int>()
        var sum = 0
        var index = 0
        while (index < nums.size) {
            if (nums[index] in map) {
                sum = 0
                index = map[nums[index]]!! + 1
                map.clear()
            } else {
                sum += nums[index]
                map[nums[index]] = index
                index++
            }
            answer = max(answer, sum)
        }
        return answer
    }
}

fun main() {
    val prob = Problem1695()
    println(prob.maximumUniqueSubarray(intArrayOf(4,2,4,5,6))) // 17
    println(prob.maximumUniqueSubarray(intArrayOf(5,2,1,2,5,2,1,2,5))) // 8
    println(prob.maximumUniqueSubarray(intArrayOf(2,4,4,4,5,6,3,4,3))) // 18
    println(prob.maximumUniqueSubarray(intArrayOf(3,4,5,3,8,4,6))) // 26
    println(prob.maximumUniqueSubarray(intArrayOf(187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434))) // 16911
}
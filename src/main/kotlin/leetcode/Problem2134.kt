package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
class Problem2134 {
    fun minSwaps(nums: IntArray): Int {
        var numOnes = 0
        for (num in nums) {
            if (num == 1) {
                numOnes++
            }
        }
        var answer = Int.MAX_VALUE
        for (i in nums.indices) {
            if (nums[i] == 0) {
                continue
            }
            var numZeros = 0
            var j = i
            while (j < i + numOnes) {
                if (nums[j % nums.size] == 0) {
                    numZeros++
                }
                j++
            }
            answer = min(answer, numZeros)
        }
        return if (answer == Int.MAX_VALUE) 0 else answer
    }
}

fun main() {
    val prob = Problem2134()
    println(prob.minSwaps(intArrayOf(0,1,0,1,1,0,0))) // 1
    println(prob.minSwaps(intArrayOf(0,1,1,1,0,0,1,1,0))) // 2
    println(prob.minSwaps(intArrayOf(1,1,0,0,1))) // 0
    println(prob.minSwaps(intArrayOf(0,1,0,1,0,1,0,1,0,1))) // 2
    println(prob.minSwaps(intArrayOf(1,0,0,1,1,1,0,0,0,1,1,0))) // 2
    println(prob.minSwaps(intArrayOf(1,0,0,1,1,1,0,0,0,1,1,0))) // 2
    println(prob.minSwaps(intArrayOf(1,0,0,0,1,1,0,0,1,0,1,0,0,1,1,0,0))) // 3
}
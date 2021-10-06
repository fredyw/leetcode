package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
class Problem1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }
        var answer = Int.MAX_VALUE
        for (day in bloomDay) {
            var bouquets = m
            var flowers = k
            var i = 0
            while (i < bloomDay.size) {
                while (i < bloomDay.size && bloomDay[i] <= day) {
                    if (flowers - 1 == 0) {
                        bouquets--
                        flowers = k
                    } else {
                        flowers--
                    }
                    if (bouquets == 0) {
                        answer = min(answer, day)
                    }
                    i++
                }
                flowers = k
                i++
            }
        }
        return if (answer == Int.MAX_VALUE) -1 else answer
    }
}

fun main() {
    val prob = Problem1482()
    println(prob.minDays(intArrayOf(1,10,3,10,2), 3, 1)) // 3
    println(prob.minDays(intArrayOf(1,10,3,10,2), 3, 2)) // -1
    println(prob.minDays(intArrayOf(7,7,7,7,12,7,7), 2, 3)) // 12
    println(prob.minDays(intArrayOf(1000000000,1000000000), 1, 1)) // 1000000000
    println(prob.minDays(intArrayOf(1,10,2,9,3,8,4,7,5,6), 4, 2)) // 9
}
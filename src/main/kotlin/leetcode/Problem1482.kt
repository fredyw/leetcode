package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
class Problem1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }
        val set = TreeSet<Int>()
        for (day in bloomDay) {
            set += day
        }
        for (day in set) {
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
                        return day
                    }
                    i++
                }
                flowers = k
                i++
            }
        }
        return -1
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
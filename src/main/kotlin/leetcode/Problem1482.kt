package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 */
class Problem1482 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (bloomDay.size < m * k) {
            return -1
        }
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (day in bloomDay) {
            min = min(min, day)
            max = max(max, day)
        }
        while (min <= max) {
            val mid = min + ((max - min) / 2)
            if (isValid(bloomDay, m, k, mid)) {
                max = mid - 1
            } else {
                min = mid + 1
            }
        }
        return min
    }

    private fun isValid(bloomDay: IntArray, m: Int, k: Int, day: Int): Boolean {
        var bouquets = 0
        var flowers = 0
        for (d in bloomDay) {
            if (d > day) {
                flowers = 0
            } else {
                flowers++
            }
            if (flowers == k) {
                flowers = 0
                bouquets++
            }
            if (bouquets == m) {
                return true
            }
        }
        return false
    }
}

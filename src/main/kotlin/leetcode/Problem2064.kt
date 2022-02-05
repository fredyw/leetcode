package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 */
class Problem2064 {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        var min = 1
        var max = quantities[0]
        for (i in 1 until quantities.size) {
            max = max(max, quantities[i])
        }
        var answer = 0
        while (min <= max) {
            val mid = (min + max) / 2
            if (canDistribute(n, quantities, mid)) {
                max = mid - 1
                answer = mid
            } else {
                min = mid + 1
            }
        }
        return answer
    }

    private fun canDistribute(stores: Int, quantities: IntArray, x: Int): Boolean {
        var n = stores
        for (quantity in quantities) {
            n -= if (quantity % x == 0) quantity / x else (quantity / x) + 1
            if (n < 0) {
                return false
            }
        }
        return true
    }
}

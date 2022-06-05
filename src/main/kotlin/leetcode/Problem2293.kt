package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/min-max-game/
 */
class Problem2293 {
    fun minMaxGame(nums: IntArray): Int {
        var list = nums.toList()
        while (list.size > 1) {
            val tmp = mutableListOf<Int>()
            var i = 0
            var min = true
            while (i < list.size - 1) {
                tmp += if (min) {
                    min(list[i], list[i + 1])
                } else {
                    max(list[i], list[i + 1])
                }
                min = !min
                i += 2
            }
            list = tmp
        }
        return list.first()
    }
}

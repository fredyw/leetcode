package leetcode

import kotlin.math.abs

/**
 * https://leetcode.com/problems/detect-squares/
 */
class Problem2013 {
    class DetectSquares() {
        private val map = mutableMapOf<Int, MutableMap<Int, Int>>()

        fun add(point: IntArray) {
            val x = point[0]
            val y = point[1]
            val m = map[x] ?: mutableMapOf()
            m[y] = (m[y] ?: 0) + 1
            map[x] = m
        }

        fun count(point: IntArray): Int {
            var count = 0
            val x1 = point[0]
            val y1 = point[1]
            for ((y2, _) in map[x1] ?: mapOf<Int, Int>()) {
                val length = abs(y1 - y2)
                if (length == 0) {
                    continue
                }
                count += numSquares(x1 = x1, y1 = y1, x2 = x1 - length, y2 = y2)
                count += numSquares(x1 = x1, y1 = y1, x2 = x1 + length, y2 = y2)
            }
            return count
        }

        private fun numSquares(x1: Int, y1: Int, x2: Int, y2: Int): Int {
            val p1 = if (map[x1] != null) map[x1]!![y2] ?: 0 else 0
            val p2 = if (map[x2] != null) map[x2]!![y1] ?: 0 else 0
            val p3 = if (map[x2] != null) map[x2]!![y2] ?: 0 else 0
            return p1 * p2 * p3
        }
    }
}

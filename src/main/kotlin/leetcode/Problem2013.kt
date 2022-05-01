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
            add(point)
            for ((y2, _) in map[x1] ?: mapOf<Int, Int>()) {
                val length = abs(y1 - y2)
                if (length == 0) {
                    continue
                }
                count += numSquares(x1 = x1, y1 = y1, x2 = x1 - length, y2 = y2)
                count += numSquares(x1 = x1, y1 = y1, x2 = x1 + length, y2 = y2)
            }
            remove(point)
            return count
        }

        private fun remove(point: IntArray) {
            val x = point[0]
            val y = point[1]
            val m = map[x]
            val count = m!![y]!! - 1
            if (count == 0) {
                m.remove(y)
            } else {
                m[y] = count
            }
            if (m.isEmpty()) {
                map.remove(x)
            } else {
                map[x] = m
            }
        }

        private fun numSquares(x1: Int, y1: Int, x2: Int, y2: Int): Int {
            val p1 = if (map[x1] != null) map[x1]!![y1] ?: 0 else 0
            val p2 = if (map[x1] != null) map[x1]!![y2] ?: 0 else 0
            val p3 = if (map[x2] != null) map[x2]!![y1] ?: 0 else 0
            val p4 = if (map[x2] != null) map[x2]!![y2] ?: 0 else 0
            return p1 * p2 * p3 * p4
        }
    }
}

fun main() {
    val detectSquares = Problem2013.DetectSquares()
    detectSquares.add(intArrayOf(3, 10))
    detectSquares.add(intArrayOf(11, 2))
    detectSquares.add(intArrayOf(3, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 1
    println(detectSquares.count(intArrayOf(14, 8)))  // 0
    detectSquares.add(intArrayOf(11, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 2
    detectSquares.add(intArrayOf(3, 10))
    detectSquares.add(intArrayOf(3, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 8
}
package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/describe-the-painting/
 */
class Problem1943 {
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        val map = TreeMap<Long, Long>()
        for ((start, end, color) in segments) {
            map[start.toLong()] = (map[start.toLong()] ?: 0) + color.toLong()
            map[end.toLong()] = (map[end.toLong()] ?: 0) - color.toLong()
        }
        val answer = mutableListOf<List<Long>>()
        var sum = 0L
        var previous = 0L
        for (current in map.keys) {
            if (sum > 0) {
                answer += listOf(previous, current, sum)
            }
            sum += map[current]!!
            previous = current
        }
        return answer
    }
}

package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors/
 */
class Problem2078 {
    fun maxDistance(colors: IntArray): Int {
        val prefixMap = HashMap<Int, Int>()
        val suffixMap = HashMap<Int, Int>()
        for ((index, color) in colors.withIndex()) {
            if (color !in prefixMap) {
                prefixMap += color to index
            }
        }
        for (index in (colors.size - 1) downTo 0) {
            if (colors[index] !in suffixMap) {
                suffixMap += colors[index] to index
            }
        }
        var answer = 0
        for ((key1, index1) in prefixMap) {
            for ((key2, index2) in suffixMap) {
                if (key1 == key2) {
                    continue
                }
                answer = max(answer, index2 - index1)
            }
        }
        return answer
    }
}

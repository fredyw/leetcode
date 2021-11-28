package leetcode

import java.util.*
import kotlin.math.max

/**
 * https://leetcode.com/problems/most-beautiful-item-for-each-query/
 */
class Problem2070 {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortBy { it[0] }
        val map = TreeMap<Int, Int>()
        var max = 0
        for (item in items) {
            max = max(max, item[1])
            map[item[0]] = max
        }
        val answer = IntArray(queries.size)
        for ((index, query) in queries.withIndex()) {
            val entry = map.floorEntry(query)
            answer[index] = if (entry == null) 0 else entry.value
        }
        return answer
    }
}

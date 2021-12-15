package leetcode

/**
 * https://leetcode.com/problems/rings-and-rods/
 */
class Problem2103 {
    fun countPoints(rings: String): Int {
        var i = 0
        val map = mutableMapOf<Char, MutableSet<Char>>()
        while (i < rings.length - 1) {
            val color = rings[i]
            val rod = rings[i + 1]
            val rgb = map[rod]
            if (rgb == null) {
                map[rod] = mutableSetOf()
            }
            map[rod]!!.add(color)
            i += 2
        }
        return map.values.count { it.size == 3 }
    }
}

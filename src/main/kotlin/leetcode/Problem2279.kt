package leetcode

/**
 * https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 */
class Problem2279 {
    fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
        var answer = 0
        data class Bag(val capacity: Int, val rock: Int)
        val list = mutableListOf<Bag>()
        for ((i, c) in capacity.withIndex()) {
            if (c == rocks[i]) {
                answer++
            } else {
                list += Bag(c, rocks[i])
            }
        }
        var additional = additionalRocks
        list.sortBy { it.capacity - it.rock }
        for (i in 0 until list.size) {
            val diff = list[i].capacity - list[i].rock
            if (diff > additional) {
                break
            }
            additional -= diff
            answer++
        }
        return answer
    }
}

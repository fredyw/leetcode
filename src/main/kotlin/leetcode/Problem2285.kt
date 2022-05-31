package leetcode

/**
 * https://leetcode.com/problems/maximum-total-importance-of-roads/
 */
class Problem2285 {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val roadToCount = mutableMapOf<Int, Int>()
        for ((a, b) in roads) {
            roadToCount[a] = (roadToCount[a] ?: 0) + 1
            roadToCount[b] = (roadToCount[b] ?: 0) + 1
        }
        var value = n
        val roadToValue = mutableMapOf<Int, Int>()
        for (entry in roadToCount.entries.sortedByDescending { it.value }) {
            roadToValue[entry.key] = value--
        }
        var answer = 0L
        for ((a, b) in roads) {
            answer += (roadToValue[a] ?: 0) + (roadToValue[b] ?: 0)
        }
        return answer
    }
}

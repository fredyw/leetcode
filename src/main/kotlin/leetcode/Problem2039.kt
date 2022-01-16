package leetcode

import java.lang.Integer.max
import java.util.*

/**
 * https://leetcode.com/problems/the-time-when-the-network-becomes-idle/
 */
class Problem2039 {
    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        val adjList = buildAdjList(edges)
        val queue = LinkedList<Int>()
        val visited = mutableSetOf<Int>()
        val edgeTo = mutableMapOf<Int, Int>()
        val counts = mutableMapOf<Int, Int>()
        queue.add(0)
        while (!queue.isEmpty()) {
            val current = queue.remove()
            if (current in visited) {
                continue
            }
            visited.add(current)
            val neighbors = adjList[current]
            if (neighbors != null) {
                for (neighbor in neighbors) {
                    if (neighbor in visited) {
                        continue
                    }
                    if (neighbor !in edgeTo) {
                        edgeTo[neighbor] = current
                        counts[neighbor] = (counts[current] ?: 0) + 1
                    }
                    queue.add(neighbor)
                }
            }
        }
        var answer = 0
        for (i in 1 until adjList.size) {
            val time = counts[i]!! * 2
            answer = max(answer, (time + (((time - 1) / patience[i]) * patience[i])) + 1)
        }
        return answer
    }

    private fun buildAdjList(edges: Array<IntArray>): Map<Int, List<Int>> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for (edge in edges) {
            val list1 = map[edge[0]] ?: mutableListOf()
            list1 += edge[1]
            map[edge[0]] = list1
            val list2 = map[edge[1]] ?: mutableListOf()
            list2 += edge[0]
            map[edge[1]] = list2
        }
        return map
    }
}

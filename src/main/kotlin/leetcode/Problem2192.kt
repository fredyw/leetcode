package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 */
class Problem2192 {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val adjList = reverse(n, edges)
        val answer = mutableListOf<List<Int>>()
        for (i in 0 until n) {
            val ancestors = mutableListOf<Int>()
            val visited = BooleanArray(n)
            getAncestors(i, adjList, ancestors, visited)
            ancestors.sort()
            answer += ancestors
        }
        return answer
    }

    private fun reverse(n: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val adjList = Array<MutableList<Int>>(n) { mutableListOf() }
        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]
            adjList[to].add(from)
        }
        return adjList
    }

    private fun getAncestors(i: Int, adjList: Array<MutableList<Int>>,
                             ancestors: MutableList<Int>, visited: BooleanArray) {
        visited[i] = true
        for (adjacent in adjList[i]) {
            if (!visited[adjacent]) {
                ancestors += adjacent
                getAncestors(adjacent, adjList, ancestors, visited)
            }
        }
    }
}

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
            val ancestors = TreeSet<Int>()
            getAncestors(i, adjList, ancestors)
            answer += ancestors.toList()
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
                             ancestors: TreeSet<Int>) {
        for (adjacent in adjList[i]) {
            ancestors += adjacent
            getAncestors(adjacent, adjList, ancestors)
        }
    }
}

fun main() {
    val prob = Problem2192()
    println(prob.getAncestors(8, arrayOf(
        intArrayOf(0,3), intArrayOf(0,4), intArrayOf(1,3), intArrayOf(2,4), intArrayOf(2,7),
        intArrayOf(3,5), intArrayOf(3,6), intArrayOf(3,7), intArrayOf(4,6)
    ))) // [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
    println(prob.getAncestors(5, arrayOf(
        intArrayOf(0,1), intArrayOf(0,2), intArrayOf(0,3), intArrayOf(0,4), intArrayOf(1,2),
        intArrayOf(1,3), intArrayOf(1,4), intArrayOf(2,3), intArrayOf(2,4), intArrayOf(3,4)
    ))) // [[],[0],[0,1],[0,1,2],[0,1,2,3]]
}
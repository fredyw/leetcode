package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/path-with-maximum-probability/
 */
class Problem1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int,
                       end: Int): Double {
        val adjList = buildAdjList(n, edges, succProb)
        val dist = DoubleArray(n) { Double.NEGATIVE_INFINITY }
        val queue = PriorityQueue<Node>()
        queue += Node(start, dist[start])
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            for (edge in adjList[node.n]) {
                val prob = if (dist[edge.from] == Double.NEGATIVE_INFINITY) edge.prob
                    else dist[edge.from] * edge.prob
                if (prob > dist[edge.to]) {
                    dist[edge.to] = prob
                    queue += Node(edge.to, prob)
                }
            }
        }
        return if (dist[end] == Double.NEGATIVE_INFINITY) 0.0 else dist[end]
    }

    private fun buildAdjList(n: Int, edges: Array<IntArray>, succProb: DoubleArray): Array<MutableList<Edge>> {
        val adjList = Array(n) { mutableListOf<Edge>() }
        for ((i, e) in edges.withIndex()) {
            val (from, to) = e
            adjList[from].add(Edge(from, to, succProb[i]))
            adjList[to].add(Edge(to, from, succProb[i]))
        }
        return adjList
    }

    private data class Node(val n: Int, val prob: Double) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return other.prob.compareTo(prob)
        }
    }

    private data class Edge(val from: Int, val to: Int, val prob: Double)
}

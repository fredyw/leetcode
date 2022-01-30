package leetcode

/**
 * https://leetcode.com/problems/course-schedule-iv/
 */
class Problem1462 {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>,
                            queries: Array<IntArray>): List<Boolean> {
        val adjList = buildAdjList(prerequisites)
        val dependencyMap = mutableMapOf<Int, MutableSet<Int>>()
        for (course in 0 until numCourses) {
            val dependencies = mutableSetOf<Int>()
            dfs(adjList, BooleanArray(numCourses), dependencies, course)
            dependencyMap[course] = dependencies
        }
        val answer = mutableListOf<Boolean>()
        for (query in queries) {
            answer += query[1] in dependencyMap[query[0]]!!
        }
        return answer
    }

    private fun buildAdjList(prerequisites: Array<IntArray>): Map<Int, List<Int>> {
        val adjList = mutableMapOf<Int, MutableList<Int>>()
        for (prerequisite in prerequisites) {
            val from = prerequisite[0]
            val to = prerequisite[1]
            val list = adjList[from] ?: mutableListOf()
            list += to
            adjList[from] = list
        }
        return adjList
    }

    private fun dfs(adjList: Map<Int, List<Int>>, visited: BooleanArray,
                    dependencies: MutableSet<Int>, course: Int) {
        visited[course] = true
        for (adj in (adjList[course] ?: listOf())) {
            if (!visited[adj]) {
                dfs(adjList, visited, dependencies, adj)
            }
        }
        dependencies += course
    }
}

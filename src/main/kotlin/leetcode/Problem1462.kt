package leetcode

/**
 * https://leetcode.com/problems/course-schedule-iv/
 */
class Problem1462 {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        TODO()
    }
}

fun main() {
    val prob = Problem1462()
    println(prob.checkIfPrerequisite(
        2,
        arrayOf(intArrayOf(1,0)),
        arrayOf(intArrayOf(0,1), intArrayOf(1,0)))) // [false,true]
    println(prob.checkIfPrerequisite(
        2,
        arrayOf(),
        arrayOf(intArrayOf(1,0), intArrayOf(0,1)))) // [false,true]
    println(prob.checkIfPrerequisite(
        3,
        arrayOf(intArrayOf(1,2), intArrayOf(1,0), intArrayOf(2,0)),
        arrayOf(intArrayOf(1,0), intArrayOf(1,2)))) // [true,true]
}
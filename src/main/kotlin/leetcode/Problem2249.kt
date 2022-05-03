package leetcode

/**
 * https://leetcode.com/problems/count-lattice-points-inside-a-circle/
 */
class Problem2249 {
    fun countLatticePoints(circles: Array<IntArray>): Int {
        val points = mutableSetOf<Point>()
        for (circle in circles) {
            latticePoints(circle, points)
        }
        return points.size
    }

    private data class Point(val x: Int, val y: Int)

    private fun latticePoints(circle: IntArray, points: MutableSet<Point>) {
        val (x, y, r) = circle
        // Center
        for (i in x - r..x + r) {
            points += Point(i, y)
        }
        // Top
        var k = r - 1
        for (j in y + 1..y + r) {
            for (i in x - k..x + k) {
                points += Point(i, j)
            }
            k--
        }
        // Bottom
        k = r - 1
        for (j in y - 1 downTo y - r) {
            for (i in x - k..x + k) {
                points += Point(i, j)
            }
            k--
        }
    }
}

fun main() {
    val prob = Problem2249()
    println(prob.countLatticePoints(arrayOf(intArrayOf(2,2,1)))) // 5
    println(prob.countLatticePoints(arrayOf(intArrayOf(2,2,2), intArrayOf(3,4,1)))) // 16
    println(prob.countLatticePoints(arrayOf(intArrayOf(2,2,2), intArrayOf(3,5,1)))) // 18
    println(prob.countLatticePoints(arrayOf(
        intArrayOf(8,9,6),
        intArrayOf(9,8,4),
        intArrayOf(4,1,1),
        intArrayOf(8,5,1),
        intArrayOf(7,1,1),
        intArrayOf(6,7,5),
        intArrayOf(7,1,1),
        intArrayOf(7,1,1),
        intArrayOf(5,5,3)
    ))) // 141
}
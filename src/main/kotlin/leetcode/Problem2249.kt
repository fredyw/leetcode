package leetcode

/**
 * https://leetcode.com/problems/count-lattice-points-inside-a-circle/
 */
class Problem2249 {
    fun countLatticePoints(circles: Array<IntArray>): Int {
        data class Point(val x: Int, val y: Int)
        val points = mutableSetOf<Point>()
        for (circle in circles) {
            val (x, y, r) = circle
            for (i in -r..r) {
                for (j in -r..r) {
                    if (i * i + j * j <= r * r) {
                        points += Point(x + i, y + j)
                    }
                }
            }
        }
        return points.size
    }
}

package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 */
class Problem1792 {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        val queue = PriorityQueue<IntArray> { a, b ->
            val diff1 = ((a[0] + 1).toDouble() / (a[1] + 1).toDouble()) - (a[0].toDouble() / a[1].toDouble())
            val diff2 = ((b[0] + 1).toDouble() / (b[1] + 1).toDouble()) - (b[0].toDouble() / b[1].toDouble())
            diff2.compareTo(diff1)
        }
        for (c in classes) {
            queue += c
        }
        var students = extraStudents
        while (students > 0) {
            val c = queue.poll()
            c[0]++
            c[1]++
            queue += c
            students--
        }
        var sum = 0.0
        for (c in classes) {
            sum += c[0].toDouble() / c[1].toDouble()
        }
        return sum / classes.size
    }
}

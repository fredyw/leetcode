package leetcode

/**
 * https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
 */
class Problem1954 {
    fun minimumPerimeter(neededApples: Long): Long {
        TODO()
    }

    private fun numApples(n: Long): Long {
        var totalApples = 0L
        for (i in 1..n) {
            // *-----*
            // |     |
            // *     *
            // |     |
            // *-----*
            var apples = i * 4L + ((i + i) * 4L)
            for (j in 1 until i) {
                // -**-**-
                // *     *
                // |     |
                // *     *
                // -**-**-
                apples += (i + j) * 8L
            }
            totalApples += apples
        }
        return totalApples
    }
}

fun main() {
    val prob = Problem1954()
    println(prob.minimumPerimeter(1)) // 8
    println(prob.minimumPerimeter(13)) // 16
    println(prob.minimumPerimeter(1000000000)) // 5040
}
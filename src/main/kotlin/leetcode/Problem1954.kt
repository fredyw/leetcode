package leetcode

/**
 * https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
 */
class Problem1954 {
    fun minimumPerimeter(neededApples: Long): Long {
        var answer = 0L
        var lo = 1L
        var hi = neededApples
        while (lo <= hi) {
            val mid = lo + ((hi - lo) / 2)
            // When it overflows, it will produce a negative number.
            val numApples = numApples(mid)
            if (numApples < 0 || neededApples <= numApples) {
                answer = mid
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }
        return answer * 8
    }

    fun numApples(n: Long): Long {
        return 2 * (n * (n + 1) * (2 * n + 1))
    }
}

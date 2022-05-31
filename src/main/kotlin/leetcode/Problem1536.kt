package leetcode

/**
 * https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
 */
class Problem1536 {
    fun minSwaps(grid: Array<IntArray>): Int {
        val zeroCounts = IntArray(grid.size)
        val set = mutableSetOf<Int>()
        for ((i, r) in grid.withIndex()) {
            var count = 0
            var j = r.size - 1
            while (j >= 0 && r[j] == 0) {
                count++
                j--
            }
            for (k in grid.size - 1 downTo 0) {
                if (count >= k && k !in set) {
                    set += k
                    zeroCounts[i] = grid.size - 1 - k
                    break
                }
            }
        }
        if (set.size != grid.size) {
            return -1
        }
        var answer = 0
        // Bubble sort.
        var swapped = true
        while (swapped) {
            swapped = false
            for (i in 1 until zeroCounts.size) {
                if (zeroCounts[i] < zeroCounts[i - 1]) {
                    swapped = true
                    answer++
                    val tmp = zeroCounts[i]
                    zeroCounts[i] = zeroCounts[i - 1]
                    zeroCounts[i - 1] = tmp
                }
            }
        }
        return answer
    }
}

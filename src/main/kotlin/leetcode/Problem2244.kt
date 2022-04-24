package leetcode

/**
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
 */
class Problem2244 {
    fun minimumRounds(tasks: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for (task in tasks) {
            map[task] = (map[task] ?: 0) + 1
        }
        var answer = 0
        for (count in map.values) {
            if (count < 2) {
                return -1
            }
            answer += if (count % 3 == 0) {
                count / 3
            } else if (count % 3 == 1) {
                (count / 3) - 1 + 2
            } else { // count % 3 == 2
                (count / 3) + 1
            }
        }
        return answer
    }
}

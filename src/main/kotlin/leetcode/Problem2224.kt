package leetcode

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
 */
class Problem2224 {
    fun convertTime(current: String, correct: String): Int {
        var diff = toMinutes(correct) - toMinutes(current)
        var answer = 0
        val minutes = mutableListOf(60, 15, 5, 1)
        var index = 0
        while (diff > 0) {
            if (diff - minutes[index] < 0) {
                index++
                continue
            }
            diff -= minutes[index]
            answer++
        }
        return answer
    }

    private fun toMinutes(time: String): Int {
        val (h, m) = time.split(":")
        return (h.toInt() * 60) + m.toInt()
    }
}

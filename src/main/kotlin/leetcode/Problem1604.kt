package leetcode

/**
 * https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
class Problem1604 {
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (i in keyName.indices) {
            val times = map[keyName[i]] ?: mutableListOf()
            times += keyTime[i]
            map[keyName[i]] = times
        }
        val answer = mutableListOf<String>()
        for ((key, value) in map) {
            var i = 0
            value.sort()
            while (i < value.size - 2) {
                val t = difference(value[i], value[i + 1]) + difference(value[i + 1], value[i + 2])
                if (t <= 60) {
                    answer += key
                    break
                }
                i++
            }
        }
        answer.sort()
        return answer
    }

    private fun difference(from: String, to: String): Int {
        val (fromHour, fromMinute) = from.split(":")
        val (toHour, toMinute) = to.split(":")
        val minute = toMinute.toInt() - fromMinute.toInt()
        val hour = (toHour.toInt() - fromHour.toInt()) * 60
        return minute + hour
    }
}

package leetcode

/**
 * https://leetcode.com/problems/sender-with-largest-word-count/
 */
class Problem2284 {
    fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
        var answer = ""
        var max = 0
        val map = mutableMapOf<String, Int>()
        for ((index, message) in messages.withIndex()) {
            map[senders[index]] = (map[senders[index]] ?: 0) + message.split(" ").size
            val count = map[senders[index]] ?: 0
            if (count > max) {
                answer = senders[index]
                max = count
            } else if (count == max) {
                if (answer < senders[index]) {
                    answer = senders[index]
                }
            }
        }
        return answer
    }
}

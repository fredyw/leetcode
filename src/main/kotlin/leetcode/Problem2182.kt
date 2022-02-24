package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 */
class Problem2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        data class CharCount(val char: Char, val count: Int)
        val array = IntArray(26)
        for (char in s) {
            array[char - 'a']++
        }
        val queue = PriorityQueue<CharCount> {a, b -> b.char.compareTo(a.char)}
        for (i in array.indices) {
            if (array[i] == 0) {
                continue
            }
            queue += CharCount((i + 'a'.toInt()).toChar(), array[i])
        }
        val answer = StringBuilder()
        var lastChar: Char? = null
        var lastCount = 0
        while (queue.isNotEmpty()) {
            var e1: CharCount? = null
            if (queue.isNotEmpty()) {
                e1 = queue.remove()
                if (lastChar == e1.char && lastCount == repeatLimit && queue.isEmpty()) {
                    break
                }
                var n = if (lastChar == e1.char) lastCount else 0
                var count = 0
                if (e1.count > repeatLimit - n) {
                    answer.append(e1.char.toString().repeat(repeatLimit - n))
                    count = repeatLimit - n
                    e1 = CharCount(e1.char, e1.count - (repeatLimit - n))
                } else { // if (e1.count <= repeatLimit - n) {
                    answer.append(e1.char.toString().repeat(e1.count))
                    count = e1.count
                    e1 = null
                }
                if (lastChar == e1?.char) {
                    lastCount += count
                } else {
                    lastChar = e1?.char
                    lastCount = count
                }
            }
            var e2: CharCount? = null
            if (queue.isNotEmpty()) {
                e2 = queue.remove()
                answer.append(e2?.char)
                if (e2.count - 1 > 0) {
                    e2 = CharCount(e2.char, e2.count - 1)
                } else if (e2.count - 1 == 0) {
                    e2 = null
                }
                lastChar = e2?.char
                lastCount = 1
            }
            if (e1 != null) {
                queue += e1
            }
            if (e2 != null) {
                queue += e2
            }
        }
        return answer.toString()
    }
}

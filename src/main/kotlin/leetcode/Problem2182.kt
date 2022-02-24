package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 */
class Problem2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val map = mutableMapOf<Char, Int>()
        for (char in s) {
            map[char] = (map[char] ?: 0) + 1
        }
        data class CharCount(val char: Char, val count: Int)
        val list = map.map { CharCount(it.key, it.value) }
        val queue = PriorityQueue<CharCount> {a, b -> b.char.compareTo(a.char)}
        queue += list
        val answer = StringBuilder()
        var lastChar: Char? = null
        var lastCount = 0
        while (queue.isNotEmpty()) {
            var e1: CharCount? = null
            if (queue.isNotEmpty()) {
                e1 = queue.remove()
                var n = if (lastChar == e1.char) lastCount else 0
                var count = 0
                if (e1.count > repeatLimit - n) {
                    if (repeatLimit - n < 0) {
                        break
                    }
                    answer.append(e1.char.toString().repeat(repeatLimit - n))
                    count = repeatLimit - n
                    e1 = CharCount(e1.char, e1.count - (repeatLimit - n))
                } else { // if (e1.count <= repeatLimit - n) {
                    answer.append(e1.char.toString().repeat(e1.count))
                    count = repeatLimit - n
                    e1 = null
                }
                if (lastChar == e1?.char) {
                    lastCount++
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

fun main() {
    val prob = Problem2182()
    println(prob.repeatLimitedString("cczazcc", 3)) // "zzcccac"
    println(prob.repeatLimitedString("aababab", 2)) // "bbabaa"
    println(prob.repeatLimitedString("cczazcczz", 3)) // "zzzczccca"
    println(prob.repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt", 1)) // "zyxyxwxwvwvuvuvututstrtrtqpqpqponononmlmkmkjigifiededededcbaba"
}
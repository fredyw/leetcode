package leetcode

/**
 * https://leetcode.com/problems/plates-between-candles/
 */
class Problem2055 {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val answer = IntArray(queries.size)
        var startIndex = 0
        while (startIndex < s.length && s[startIndex] != '|') {
            startIndex++
        }
        var endIndex = s.length - 1
        while (endIndex >= 0 && s[endIndex] != '|') {
            endIndex--
        }
        if (endIndex <= startIndex) {
            return answer
        }
        val prefixSums = IntArray(s.length)
        val candles = mutableListOf<Int>()
        for ((index, value) in s.withIndex()) {
            if (value == '*') {
                prefixSums[index] = if (index - 1 < 0) 1  else prefixSums[index - 1] + 1
            } else {
                candles += index
                prefixSums[index] = if (index - 1 < 0) 0 else prefixSums[index - 1]
            }
        }
        data class PreviousNextCandle(val previous: Int, val next: Int)
        val previousNextCandle = Array(s.length) { PreviousNextCandle(-1, -1) }
        var candleIndex = 0
        var index = startIndex
        while (index <= endIndex) {
            if (index != startIndex && s[index] == '|') {
                candleIndex++
            } else if (s[index] == '*') {
                previousNextCandle[index] =
                    PreviousNextCandle(candles[candleIndex], candles[candleIndex + 1])
            }
            index++
        }
        for ((index, query) in queries.withIndex()) {
            var start = query[0]
            if (s[start] == '*') {
                start = if (start <= startIndex) {
                    startIndex
                } else if (start >= endIndex) {
                    endIndex
                } else {
                    previousNextCandle[start].next
                }
            }
            var end = query[1]
            if (s[end] == '*') {
                end = if (end <= startIndex) {
                    startIndex
                } else if (end >= endIndex) {
                    endIndex
                } else {
                    previousNextCandle[end].previous
                }
            }
            answer[index] = if (start > end) 0 else prefixSums[end] - prefixSums[start]
        }
        return answer
    }
}

fun main() {
    val prob = Problem2055()
//    println(prob.platesBetweenCandles("**|**|***|", arrayOf(intArrayOf(2,5), intArrayOf(5,9))).contentToString()) // [2,3]
//    println(prob.platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(1,17),intArrayOf(4,5),intArrayOf(14,17),intArrayOf(5,11),intArrayOf(15,16),intArrayOf(5,9),intArrayOf(5,13))).contentToString()) // [9,0,0,0,0,0,5]
//    println(prob.platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(5,9),intArrayOf(5,13))).contentToString()) // [0,5]
    println(prob.platesBetweenCandles("***", arrayOf(intArrayOf(2,2))).contentToString()) // [0,5]
}
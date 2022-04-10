package leetcode

import java.util.Collections

/**
 * https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 */
class Problem2231 {
    fun largestInteger(num: Int): Int {
        val oddIndexes = mutableListOf<Int>()
        val evenIndexes = mutableListOf<Int>()
        val numString = num.toString()
        for ((i, n) in numString.withIndex()) {
            if (n.toInt() % 2 != 0) {
                oddIndexes += i
            } else {
                evenIndexes += i
            }
        }
        var answer = CharArray(numString.length)
        val sortedOddIndexes = oddIndexes.toMutableList()
        val sortedEvenIndexes = evenIndexes.toMutableList()
        Collections.sort(sortedOddIndexes, {a, b -> numString[b].compareTo(numString[a])})
        Collections.sort(sortedEvenIndexes, {a, b -> numString[b].compareTo(numString[a])})
        if (numString[0].toInt() % 2 != 0) {
            for ((i, j) in oddIndexes.withIndex()) {
                answer[j] = numString[sortedOddIndexes[i]]
            }
            for ((i, j) in evenIndexes.withIndex()) {
                answer[j] = numString[sortedEvenIndexes[i]]
            }
        } else {
            for ((i, j) in evenIndexes.withIndex()) {
                answer[j] = numString[sortedEvenIndexes[i]]
            }
            for ((i, j) in oddIndexes.withIndex()) {
                answer[j] = numString[sortedOddIndexes[i]]
            }
        }
        return String(answer).toInt()
    }
}

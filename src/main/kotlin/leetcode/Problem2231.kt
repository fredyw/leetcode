package leetcode

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
        val sortedOddIndexes = oddIndexes.sortedWith(Comparator {a, b -> numString[b].compareTo(numString[a])})
        val sortedEvenIndexes = evenIndexes.sortedWith(Comparator {a, b -> numString[b].compareTo(numString[a])})
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

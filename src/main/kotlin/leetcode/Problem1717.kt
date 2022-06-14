package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 */
class Problem1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        if (x > y) {
            return maximumGain(s, x, y, 'a', 'b')
        }
        return maximumGain(s, y, x, 'b', 'a')
    }

    private fun maximumGain(s: String, value1: Int, value2: Int, first: Char, second: Char): Int {
        var gain = 0
        var stack1 = Stack<Char>()
        for (i in s.indices) {
            if (stack1.isNotEmpty() && stack1.peek() == first && s[i] == second) {
                gain += value1
                stack1.pop()
            } else {
                stack1.add(s[i])
            }
        }
        val stack2 = Stack<Char>()
        for (c in stack1) {
            if (stack2.isNotEmpty() && stack2.peek() == second && c == first) {
                gain += value2
                stack2.pop()
            } else {
                stack2.add(c)
            }
        }
        return gain
    }
}

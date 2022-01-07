package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
 */
class Problem1541 {
    fun minInsertions(s: String): Int {
        var answer = 0
        val stack = Stack<Char>()
        var i = 0
        while (i < s.length) {
            if (s[i] == '(') {
                stack.add(s[i])
                i++
            } else if (s[i] == ')' && (i + 1 == s.length || s[i + 1] != ')')) {
                if (stack.isEmpty()) {
                    answer += 2
                } else {
                    stack.pop()
                    answer++
                }
                i++
            } else if (s[i] == ')' && s[i + 1] == ')') {
                if (stack.isEmpty()) {
                    answer++
                } else {
                    stack.pop()
                }
                i += 2
            }
        }
        while (!stack.isEmpty()) {
            answer += 2
            stack.pop()
        }
        return answer
    }
}


package leetcode

import kotlin.math.exp

/**
 * https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/
 */
class Problem2232 {
    fun minimizeResult(expression: String): String {
        var answer = ""
        var min = Int.MAX_VALUE
        val index = expression.indexOf('+')
        for (i in 0 until index) {
            for (j in index + 2 .. expression.length) {
                val s = StringBuilder(expression).insert(i, '(').insert(j + 1, ')').toString()
                val value = evaluate(s)
                if (value < min) {
                    answer = s
                    min = value
                }
            }
        }
        return answer
    }

    private fun evaluate(expression: String): Int {
        val openParenIndex = expression.indexOf('(')
        val plusIndex = expression.indexOf('+')
        val closeParenIndex = expression.indexOf(')')
        val a = if (openParenIndex == 0) 1
            else expression.substring(0, openParenIndex).toInt()
        val b = expression.substring(openParenIndex + 1, plusIndex).toInt()
        val c = expression.substring(plusIndex + 1, closeParenIndex).toInt()
        val d = if (closeParenIndex + 1 == expression.length) 1
            else expression.substring(closeParenIndex + 1).toInt()
        return a * (b + c) * d
    }
}

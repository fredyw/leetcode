package leetcode

import java.util.*
import kotlin.math.max

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
class Problem84 {
    fun largestRectangleArea(heights: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()
        for (i in 0..heights.size) {
            var currentHeight = if (i == heights.size) -1 else heights[i]
            while (!stack.isEmpty() && currentHeight <= heights[stack.peek()]) {
                val prevIndex = stack.pop()
                val height = heights[prevIndex]
                val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                answer = max(answer, height * width)
            }
            stack += i
        }
        return answer
    }
}

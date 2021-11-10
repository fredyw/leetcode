package leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */
class Problem2058 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var previous: ListNode? = head
        var current: ListNode? = previous?.next ?: return intArrayOf(-1, -1)
        var next: ListNode? = current?.next ?: return intArrayOf(-1, -1)
        var min = -1
        var max = -1
        var position = 2
        val positions = mutableListOf<Int>()
        while (next != null) {
            var found = false
            if (previous!!.`val` < current!!.`val` && current!!.`val` > next!!.`val`) {
                positions += position
                found = true
            } else if (previous!!.`val` > current!!.`val` && current!!.`val` < next!!.`val`) {
                positions += position
                found = true
            }
            if (found && positions.size >= 2) {
                min = if (min == -1) position - positions[positions.size - 2]
                    else min(min, position - positions[positions.size - 2])
                max = if (max == -1) position - positions[0]
                    else max(max, position - positions[0])
            }
            previous = current
            current = next
            next = next.next
            position++
        }
        return intArrayOf(min, max)
    }
}

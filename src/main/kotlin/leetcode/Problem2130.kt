package leetcode

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 */
class Problem2130 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun pairSum(head: ListNode?): Int {
        val list = mutableListOf<Int>()
        var node = head
        while (node != null) {
            list += node.`val`
            node = node.next
        }
        var answer = 0
        var i = 0
        var j = list.size - 1
        while (i < j) {
            answer = max(answer, list[i++] + list[j--])
        }
        return answer
    }
}

package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 */
class Problem2074 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        var finalList = mutableListOf<Int>()
        var oddList = LinkedList<Int>()
        var evenList = LinkedList<Int>()
        var node = head
        var group = 1
        var count = 0
        while (node != null) {
            if (group % 2 == 0) {
                while (!oddList.isEmpty()) {
                    finalList.add(oddList.removeFirst())
                }
                evenList.add(node.`val`)
            } else {
                while (!evenList.isEmpty()) {
                    finalList.add(evenList.removeLast())
                }
                oddList.add(node.`val`)
            }
            count++
            if (count == group) {
                group++
                count = 0
            }
            node = node.next
        }
        if (!oddList.isEmpty()) {
            val even = oddList.size % 2 == 0
            while (!oddList.isEmpty()) {
                finalList.add(if (even) {
                    oddList.removeLast()
                } else {
                    oddList.removeFirst()
                })
            }
        } else if (!evenList.isEmpty()) {
            val even = evenList.size % 2 == 0
            while (!evenList.isEmpty()) {
                finalList.add(if (even) {
                    evenList.removeLast()
                } else {
                    evenList.removeFirst()
                })
            }
        }
        var answer: ListNode? = null
        node = null
        for (e in finalList) {
            if (node == null) {
                node = ListNode(e)
                answer = node
            } else {
                node.next = ListNode(e)
                node = node.next
            }
        }
        return answer
    }
}

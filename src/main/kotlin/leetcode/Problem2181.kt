package leetcode

/**
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 */
class Problem2181 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeNodes(head: ListNode?): ListNode? {
        var node: ListNode? = head
        var newHead: ListNode? = null
        var newNode: ListNode? = newHead
        var sum = 0
        while (node != null) {
            if (node.`val` == 0) {
                if (sum > 0) {
                    if (newNode == null) {
                        newHead = ListNode(sum)
                        newNode = newHead
                    } else {
                        newNode.next = ListNode(sum)
                        newNode = newNode.next
                    }
                }
                sum = 0
            } else {
                sum += node.`val`
            }
            node = node.next
        }
        return newHead
    }
}

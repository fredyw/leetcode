package leetcode

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
class Problem2095 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteMiddle(head: ListNode?): ListNode? {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node?.next
        }
        if (size == 1) {
            return null
        }
        var middle = size / 2
        node = head
        var i = 0
        while (node != null) {
            if (i == middle - 1) {
                node?.next = node?.next?.next
            }
            node = node?.next
            i++
        }
        return head
    }
}

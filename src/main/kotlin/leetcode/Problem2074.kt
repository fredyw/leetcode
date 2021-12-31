package leetcode

/**
 * https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 */
class Problem2074 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        TODO()
    }
}

fun build(list: List<Int>): Problem2074.ListNode? {
    var head: Problem2074.ListNode? = null
    var current: Problem2074.ListNode? = null
    for (n in list) {
        if (head == null) {
            head = Problem2074.ListNode(n)
            current = head
        } else {
            current?.next = Problem2074.ListNode(n)
            current = current?.next
        }
    }
    return head
}

fun print(head: Problem2074.ListNode): List<Int> {
    var list = mutableListOf<Int>()
    var node: Problem2074.ListNode? = head
    while (node != null) {
        list.add(node.`val`)
        node = node.next
    }
    return list
}

fun main() {
    val prob = Problem2074()
    prob.reverseEvenLengthGroups(build(listOf(5,2,6,3,9,1,7,3,8,4))) // [5,6,2,3,9,1,4,8,3,7]
    prob.reverseEvenLengthGroups(build(listOf(1,1,0,6))) // [1,0,1,6]
    prob.reverseEvenLengthGroups(build(listOf(1,1,0,6,5))) // [1,0,1,5,6]
}
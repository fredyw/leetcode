package leetcode

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
class Problem2095 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteMiddle(head: ListNode?): ListNode? {
        TODO()
    }
}

fun build(array: IntArray): Problem2095.ListNode? {
    var head: Problem2095.ListNode? = null
    var current: Problem2095.ListNode? = null
    for (i in array) {
        if (head == null) {
            head = Problem2095.ListNode(i)
            current = head
        } else {
            current?.next = Problem2095.ListNode(i)
            current = current?.next
        }
    }
    return head
}

fun print(head: Problem2095.ListNode?) {
    var i = head
    while (i != null) {
        print("${i.`val`} ")
        i = i?.next
    }
    println()
}

fun main() {
    val prob = Problem2095()
    print(prob.deleteMiddle(build(intArrayOf(1,3,4,7,1,2,6)))) // [1,3,4,1,2,6]
    print(prob.deleteMiddle(build(intArrayOf(1,2,3,4)))) // [1,2,4]
    print(prob.deleteMiddle(build(intArrayOf(2,1)))) // [2]
}
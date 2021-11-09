package leetcode

/**
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */
class Problem2058 {
    class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }

    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        TODO()
    }
}

fun build(list: List<Int>): Problem2058.ListNode? {
    var head: Problem2058.ListNode? = null
    var current: Problem2058.ListNode? = null
    for ((index, num) in list.withIndex()) {
        if (index == 0) {
            head = Problem2058.ListNode(num)
            current = head
        } else {
            current?.next = Problem2058.ListNode(num)
            current = current?.next
        }
    }
    return head
}

fun Problem2058.ListNode.toList(): List<Int> {
    val list = mutableListOf<Int>()
    var node = this
    while (node.next != null) {
        list += node.`val`
        node = node.next as Problem2058.ListNode
    }
    return list
}

fun main() {
    val prob = Problem2058()
    println(prob.equals(build(intArrayOf(3,1)))) // [-1,-1]
    println(prob.equals(build(intArrayOf(5,3,1,2,5,1,2)))) // [1,3]
    println(prob.equals(build(intArrayOf(1,3,2,2,3,2,2,2,7)))) // [3,3]
    println(prob.equals(build(intArrayOf(2,3,3,2)))) // [-1,-1]
}
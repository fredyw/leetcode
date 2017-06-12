package leetcode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Problem160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        for (ListNode n = headA; n != null; n = n.next) {
            sizeA++;
        }
        int sizeB = 0;
        for (ListNode n = headB; n != null; n = n.next) {
            sizeB++;
        }
        int diff = Math.abs(sizeA - sizeB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < diff; i++) {
                nodeA = nodeA.next;
            }
        } else if (sizeA < sizeB) {
            for (int i = 0; i < diff; i++) {
                nodeB = nodeB.next;
            }
        }
        for (ListNode a = nodeA, b = nodeB; a != null || b != null; a = a.next, b = b.next) {
            if (a == b) {
                return a;
            }
        }
        return null;
    }
}

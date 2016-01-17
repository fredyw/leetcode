package leetcode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class Problem328 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = null;
        int i = 1;
        ListNode next = null;
        for (ListNode node = head; node != null; node = next) {
            next = node.next;
            node.next = null;
            if (i % 2 == 0) {
                if (even == null) {
                    evenHead = node;
                    even = node;
                } else {
                    even.next = node;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    odd = node;
                } else {
                    odd.next = node;
                    odd = odd.next;
                }
            }
            i++;
        }
        odd.next = evenHead;
        return head;
    }
}

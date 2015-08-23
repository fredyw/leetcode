package leetcode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class Problem61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }
        k = k % size;
        if (k == 0) {
            return head;
        }
        int n = size - k - 1;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        ListNode tail = newHead.next;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        if (tail != null) {
            tail.next = head;
        } else {
            newHead.next = head;
        }
        return newHead;
    }
}

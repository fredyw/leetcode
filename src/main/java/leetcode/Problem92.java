package leetcode;

/**
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 */
public class Problem92 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode left = null;
        for (ListNode node = head; node != null; node = node.next) {
            if (i + 1 == m) {
                left = node;
                i++;
            } else if (i == m) {
                ListNode right = null;
                ListNode prev = null;
                ListNode current = node;
                while (i++ <= n) {
                    ListNode next = current.next;
                    current.next = prev;
                    prev = current;
                    if (right == null) {
                        right = current;
                    }
                    current = next;
                }
                if (right != null) {
                    right.next = current;
                }
                if (left != null) {
                    left.next = prev;
                } else {
                    head = prev;
                }
            } else {
                i++;
            }
        }
        return head;
    }
}

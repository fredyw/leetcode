package leetcode;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class Problem86 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode left = null;
        ListNode right = null;
        ListNode headLeft = null;
        ListNode headRight = null;
        for (ListNode n = head; n != null; n = n.next) {
            if (n.val < x) {
                if (left == null) {
                    left = new ListNode(n.val);
                    headLeft = left;
                } else {
                    left.next = new ListNode(n.val);
                    left = left.next;
                }
            } else {
                if (right == null) {
                    right = new ListNode(n.val);
                    headRight = right;
                } else {
                    right.next = new ListNode(n.val);
                    right = right.next;
                }
            }
        }
        if (left != null) {
            left.next = headRight;
            return headLeft;
        }
        return head;
    }
}

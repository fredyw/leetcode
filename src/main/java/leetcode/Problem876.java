package leetcode;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Problem876 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) {
            size++;
        }
        int index = size / 2;
        int i = 0;
        for (ListNode n = head; n != null; n = n.next) {
            if (i++ == index) {
                return n;
            }
        }
        return head;
    }
}

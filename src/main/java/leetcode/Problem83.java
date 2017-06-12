package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Problem83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        for (ListNode n = head; n != null; n = n.next) {
            if (n.val == tmp.val) {
                continue;
            }
            tmp.next = n;
            tmp = tmp.next;
        }
        tmp.next = null;
        return head;
    }
}

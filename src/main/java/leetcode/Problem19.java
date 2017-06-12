package leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode tmp = head;
        boolean maxSize = false;
        for (int i = 0; i <= n; i++) {
            if (tmp == null) {
                maxSize = true;
                break;
            }
            tmp = tmp.next;
        }
        if (maxSize) {
            return head.next;
        } else {
            ListNode toBeRemoved = head;
            for (ListNode node = tmp; node != null; node = node.next) {
                toBeRemoved = toBeRemoved.next;
            }
            toBeRemoved.next = toBeRemoved.next.next;
        }
        return head;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Problem141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode one = head; // one step
        ListNode two = head; // two steps
        while (one != null && two != null) {
            one = one.next;
            if (two.next == null) {
                break;
            }
            two = two.next.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}

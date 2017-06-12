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
        if (head == null) {
            return false;
        }
        ListNode one = head;
        ListNode two = head; // iterate two times the speed of one
        while (true) {
            if (one == null) {
                break;
            }
            if (two == null) {
                break;
            }
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

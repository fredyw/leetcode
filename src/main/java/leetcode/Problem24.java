package leetcode;

/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Problem24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        // swapping 3 an 4
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //      ^    ^    ^    ^
        //      |    |    |    |
        //      n1   n2   n3   n4
        ListNode n1 = null;
        ListNode n2 = head;
        ListNode n3 = head.next;
        ListNode n4 = null;
        boolean once = false;
        while (n2 != null && n3 != null) {
            n4 = n3.next;
            n3.next = n2;
            n2.next = n4;
            if (n1 != null) {
                n1.next = n3;
            }
            if (!once) {
                head = n3;
                once = true;
            }
            // restore everything back
            ListNode tmp = n2;
            n2 = n3;
            n3 = tmp;
            if (n2.next == null || n3.next == null) {
                break;
            }
            n1 = n3;
            n2 = n2.next.next;
            n3 = n3.next.next;
        }
        return head;
    }
}

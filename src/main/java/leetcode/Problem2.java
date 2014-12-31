package leetcode;

/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 */
public class Problem2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tmp = null;
        ListNode a = l1;
        ListNode b = l2;
        boolean carry = false;
        while (a != null && b != null) {
            int val = a.val + b.val;
            if (carry) {
                val += 1;
            }
            if (val >= 10) {
                val = val % 10;
                carry = true;
            } else {
                carry = false;
            }
            if (tmp == null) {
                tmp = new ListNode(val);
                result = tmp;
            } else {
                tmp.next = new ListNode(val);
                tmp = tmp.next;
            }
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            int val = a.val;
            if (carry) {
                val += 1;
            }
            if (val >= 10) {
                val = val % 10;
                carry = true;
            } else {
                carry = false;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            a = a.next;
        }
        while (b != null) {
            int val = b.val;
            if (carry) {
                val += 1;
            }
            if (val >= 10) {
                val = val % 10;
                carry = true;
            } else {
                carry = false;
            }
            tmp.next = new ListNode(val);
            tmp = tmp.next;
            b = b.next;
        }
        if (carry) {
            tmp.next = new ListNode(1);
        }
        return result;
    }
}

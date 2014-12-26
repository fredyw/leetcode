package leetcode;

/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class Problem21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = null;
        ListNode result = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (tmp == null) {
                    tmp = new ListNode(l1.val);
                    result = tmp;
                } else {
                    tmp.next = new ListNode(l1.val);
                    tmp = tmp.next;
                }
                l1 = l1.next;
            } else {
                if (tmp == null) {
                    tmp = new ListNode(l2.val);
                    result = tmp;
                } else {
                    tmp.next = new ListNode(l2.val);
                    tmp = tmp.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            for (ListNode i = l1; i != null; i = i.next) {
                if (tmp == null) {
                    tmp = new ListNode(i.val);
                    result = tmp;
                } else {
                    tmp.next = new ListNode(i.val);
                    tmp = tmp.next;
                }
            }
        }
        if (l2 != null) {
            for (ListNode i = l2; i != null; i = i.next) {
                if (tmp == null) {
                    tmp = new ListNode(i.val);
                    result = tmp;
                } else {
                    tmp.next = new ListNode(i.val);
                    tmp = tmp.next;
                }
            }
        }
        return result;
    }
}

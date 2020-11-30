package leetcode;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 */
public class Problem1669 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tailList2 = null;
        for (ListNode n = list2; n != null; n = n.next) {
            if (n.next == null) {
                tailList2 = n;
                break;
            }
        }
        int i = 0;
        ListNode prev = null;
        for (ListNode cur = list1; cur != null; cur = cur.next, i++) {
            if (i == a) {
                prev.next = list2;
            }
            if (i == b) {
                tailList2.next = cur.next;
                break;
            }
            prev = cur;
        }
        return list1;
    }
}

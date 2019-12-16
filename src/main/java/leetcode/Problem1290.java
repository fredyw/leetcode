package leetcode;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Problem1290 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        String s = "";
        for (ListNode n = head; n != null; n = n.next) {
            s += n.val;
        }
        return Integer.parseInt(s, 2);
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class Problem203 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        while (node != null) {
            if (node.next != null) {
                while (node.next.val == val) {
                    node.next = node.next.next;
                    if (node.next == null) {
                        break;
                    }
                }
            }
            node = node.next;
        }
        return head;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Problem206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNodeRef ref = new ListNodeRef();
        reverse(head, ref);
        return ref.head;
    }

    private static class ListNodeRef {
        private ListNode head;
    }

    private static ListNode reverse(ListNode head, ListNodeRef ref) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (next == null) {
            ref.head = head;
            return head;
        }
        head.next = null;
        ListNode node = reverse(next, ref);
        node.next = head;
        return head;
    }
}

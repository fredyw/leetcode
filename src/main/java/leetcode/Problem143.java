package leetcode;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class Problem143 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public void reorderList(ListNode head) {
        // TODO
    }

    public static void main(String[] args) {
        Problem143 prob = new Problem143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        prob.reorderList(head);

        for (ListNode n = head; n != null; n = n.next) {
            System.out.println(head.next);
        }
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Problem25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // TODO
        return null;
    }

    private static class ListNodeRef {
        private ListNode ref;
    }

    private static void reverse(ListNode node, int k, int i, ListNodeRef ref) {

    }

    private static void print(ListNode node) {
        for (ListNode n = node; n != null; n = node.next) {
            System.out.print(n);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem25 prob = new Problem25();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(prob.reverseKGroup(head, 2));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(prob.reverseKGroup(head, 3));
    }
}

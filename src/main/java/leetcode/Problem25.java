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
        ListNodeRef ref = new ListNodeRef();
        ListNode n = reverse(head, k, 1, ref);
        n.next = ref.second;
        return ref.first;
    }

    private static class ListNodeRef {
        private ListNode first;
        private ListNode second;
    }

    private static ListNode reverse(ListNode node, int k, int i, ListNodeRef ref) {
        if (i == k) {
            ref.first = node;
            ref.second = node.next;
            return node;
        }
        ListNode n = reverse(node.next, k, i + 1, ref);
        n.next = node;
        node.next = null;
        return node;
    }

    private static void print(ListNode node) {
        for (ListNode n = node; n != null; n = n.next) {
            System.out.print(n + " ");
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
        print(prob.reverseKGroup(head, 2)); // 2 1 4 3 5

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(prob.reverseKGroup(head, 3)); // 3 2 1 4 5 
    }
}

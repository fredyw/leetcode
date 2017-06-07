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
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) {
            size++;
        }
        if (head == null || size < k) {
            return head;
        }
        Ref ref = new Ref();
        ListNode n = reverse(head, k, 1, (size / k) * k, ref);
        n.next = ref.second;
        return ref.first;
    }

    private static class Ref {
        private ListNode first;
        private ListNode second;
        private int count;
    }

    private static ListNode reverse(ListNode node, int k, int i, int j, Ref ref) {
        if (i == j) {
            ref.first = node;
            ref.second = node.next;
            ref.count++;
            return node;
        }
        ListNode n = reverse(node.next, k, i + 1, j, ref);
        if (ref.count < k) {
            n.next = node;
            node.next = null;
            ref.count++;
        } else {
            node.next = ref.first;
            n.next = ref.second;
            ref.first = node;
            ref.second = node.next;
            ref.count = 1;
        }
        return node;
    }
}

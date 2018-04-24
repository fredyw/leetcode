package leetcode;

/**
 * https://leetcode.com/problems/linked-list-components/
 */
public class Problem817 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        boolean[] nodes = new boolean[10000];
        for (int g : G) {
            nodes[g] = true;
        }
        int result = 0;
        boolean found = false;
        for (ListNode node = head; node != null; node = node.next) {
            if (nodes[node.val]) {
                if (!found) {
                    result++;
                }
                found = true;
            } else {
                found = false;
            }
        }
        return result;
    }

    private static ListNode build(int[] nodes) {
        ListNode head = null;
        ListNode node = null;
        for (int i : nodes) {
            if (head == null) {
                head = new ListNode(i);
                node = head;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return head;
    }
}

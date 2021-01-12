package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class Problem1721 {
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

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        // Destroy the linkage.
        ListNode prev = null;
        for (ListNode node = head; node != null; node = node.next) {
            if (prev != null) {
                prev.next = null;
            }
            nodes.add(node);
            prev = node;
        }
        int leftIndex = k - 1;
        int rightIndex = nodes.size() - k;
        ListNode tmp = nodes.get(leftIndex);
        nodes.set(leftIndex, nodes.get(rightIndex));
        nodes.set(rightIndex, tmp);
        // Build the linkage.
        prev = null;
        for (ListNode node : nodes) {
            if (prev != null) {
                prev.next = node;
            }
            prev = node;git
        }
        return nodes.get(0);
    }
}

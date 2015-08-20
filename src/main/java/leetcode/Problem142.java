package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Problem142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
        }
        return null;
    }
}

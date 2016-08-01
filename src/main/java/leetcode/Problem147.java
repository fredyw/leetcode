package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Problem147 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            nodes.add(n);
        }
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i; j >= 1; j--) {
                ListNode n1 = nodes.get(j);
                ListNode n2 = nodes.get(j - 1);
                if (n1.val < n2.val) {
                    nodes.set(j, n2);
                    nodes.set(j - 1, n1);
                }
            }
        }
        ListNode newHead = null;
        ListNode node = null;
        nodes.get(nodes.size() - 1).next = null;
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) {
                newHead = nodes.get(i);
                node = newHead;
            } else {
                node.next = nodes.get(i);
                node = node.next;
            }
        }
        return newHead;
    }
}

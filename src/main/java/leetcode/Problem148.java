package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class Problem148 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        // I know this is cheating
        if (head == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            nodes.add(n);
        }
        Collections.sort(nodes, (a, b) -> Integer.valueOf(a.val).compareTo(Integer.valueOf(b.val)));
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

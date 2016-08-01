package leetcode;

import java.util.ArrayList;
import java.util.List;

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
    }

    public void reorderList(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) {
            size++;
        }
        int x = 0;
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            if (x >= (size / 2)) {
                nodes.add(n);
            }
            x++;
        }
        ListNode n1 = head;
        ListNode n2 = null;
        x = 0;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            n2 = nodes.get(i);
            ListNode newTmp = n1.next;
            n1.next = n2;
            n2.next = newTmp;
            n1 = newTmp;
            x++;
        }
        if (n2 != null) {
            n2.next = null;
        }
    }
}

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Problem23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            for (ListNode n = node; n != null; n = n.next) {
                queue.add(n);
            }
        }
        ListNode answer = null; // the head
        ListNode node = null;
        while (!queue.isEmpty()) {
            ListNode n = queue.remove();
            n.next = null; // null out to avoid cycle
            if (answer == null) {
                answer = n;
                node = n;
            } else {
                node.next = n;
                node = node.next;
            }
        }
        return answer;
    }
}

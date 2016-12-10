package leetcode;

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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            for (ListNode n = node; n != null; n = n.next) {
                queue.add(n);
            }
        }
        ListNode result = null;
        ListNode resultHead = null;
        while (!queue.isEmpty()) {
            ListNode n = queue.remove();
            n.next = null;
            if (result == null) {
                result = n;
                resultHead = result;
            } else {
                result.next = n;
                result = result.next;
            }
        }
        return resultHead;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Problem82 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode toBeDeleted = null;
        ListNode safe = null;
        ListNode newHead = head;
        for (ListNode n = head; n != null; n = n.next) {
            if (toBeDeleted != null) {
                if (toBeDeleted.val == n.val) {
                    continue;
                } else {
                    if (newHead.val == toBeDeleted.val) {
                        newHead = n;
                    }
                    if (safe != null) {
                        safe.next = n;
                    } else {
                        // this is for the case like 1 -> 1 -> 2
                        if (n.next == null) {
                            return n;
                        }
                    }
                    prev = null;
                    toBeDeleted = null;
                }
            }
            if (prev != null) {
                if (prev.val == n.val) {
                    toBeDeleted = prev;
                    continue;
                } else {
                    safe = prev;
                }
            }
            prev = n;
        }
        if (safe == null) {
            return null;
        }
        // there might still be some nodes to be removed
        if (toBeDeleted != null && prev.val == toBeDeleted.val) {
            safe.next = null;
        }
        return newHead;
    }
}

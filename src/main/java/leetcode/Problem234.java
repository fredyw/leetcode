package leetcode;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Problem234 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next) {
            length++;
        }
        int mid = (length / 2) + 1;
        ListNode prev = null;
        ListNode current = head;
        int start = 1;
        while (start != mid) {
            ListNode tmp = reverse(prev, current);
            prev = current;
            current = tmp;
            start++;
        }
        current = (length % 2 == 0) ? current : current.next;
        while (prev != null && current != null) {
            if (prev.val != current.val) {
                return false;
            }
            prev = prev.next;
            current = current.next;
        }
        return true;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode c = b.next;
        b.next = a;
        return c;
    }
}

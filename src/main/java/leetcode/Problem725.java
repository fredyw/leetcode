package leetcode;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class Problem725 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        for (ListNode node = root; node != null; node = node.next) {
            size++;
        }
        int division = size / k;
        int remainder = size % k;
        ListNode[] result = new ListNode[k];
        int i = 0;
        int d = division;
        ListNode previous = null;
        ListNode current = root;
        while (current != null) {
            if (i == 0) {
                result[i++] = current;
            } else if (d <= 0) {
                if (remainder > 0) {
                    if (d == 0) {
                        previous = current;
                        current = current.next;
                    }
                    remainder--;
                }
                previous.next = null;
                result[i++] = current;
                d = division;
            }
            d--;
            previous = current;
            current = current.next;
        }
        return result;
    }

    private static ListNode build(int... nums) {
        ListNode head = null;
        ListNode next = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                head = new ListNode(nums[i]);
                next = head;
            } else {
                next.next = new ListNode(nums[i]);
                next = next.next;
            }
        }
        return head;
    }
}

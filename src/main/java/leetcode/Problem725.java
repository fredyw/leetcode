package leetcode;

import java.util.Arrays;

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

        @Override
        public String toString() {
            return "" + val;
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
        // TODO
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

    public static void main(String[] args) {
        Problem725 prob = new Problem725();
        System.out.println(Arrays.toString(prob.splitListToParts(build(1, 2, 3), 5))); // [[1],[2],[3],[],[]]
        System.out.println(Arrays.toString(prob.splitListToParts(build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3))); // [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
        System.out.println(Arrays.toString(prob.splitListToParts(build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 7))); // [[1,2],[3,4],[5,6],[7],[8],[9],[10]]
    }
}

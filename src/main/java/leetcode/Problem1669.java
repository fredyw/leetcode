package leetcode;

/**
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 */
public class Problem1669 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // TODO
        return null;
    }

    private static ListNode build(int[] array) {
        ListNode root = null;
        ListNode current = null;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                root = new ListNode(array[i]);
                current = root;
            } else {
                current.next = new ListNode(array[i]);
                current = current.next;
            }
        }
        return root;
    }

    private static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        for (ListNode n = node; n != null; n = node.next) {
            if (sb.length() == 0) {
                sb.append(node.val);
            } else {
                sb.append(",").append(node.val);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1669 prob = new Problem1669();
        System.out.println(toString(prob.mergeInBetween(
            build(new int[]{0, 1, 2, 3, 4, 5}),
            3, 4,
            build(new int[]{1000000, 1000001, 1000002})))); // [0,1,2,1000000,1000001,1000002,5]
        System.out.println(toString(prob.mergeInBetween(
            build(new int[]{0, 1, 2, 3, 4, 5, 6}),
            2, 5,
            build(new int[]{0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6})))); // [1000000,1000001,1000002,1000003,1000004]
    }
}

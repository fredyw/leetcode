package leetcode;

/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class Problem1721 {
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

    public ListNode swapNodes(ListNode head, int k) {
        // TODO
        return null;
    }

    private static ListNode build(int[] array) {
        ListNode head = new ListNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        return head;
    }

    private static void print(ListNode head) {
        for (ListNode n = head; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1721 prob = new Problem1721();
        print(prob.swapNodes(build(new int[]{1,2,3,4,5}), 2)); // [1,4,3,2,5]
        print(prob.swapNodes(build(new int[]{7,9,6,6,7,8,3,0,9,5}), 5)); // [7,9,6,6,8,7,3,0,9,5]
        print(prob.swapNodes(build(new int[]{1}), 1)); // [1]
        print(prob.swapNodes(build(new int[]{1,2}), 1)); // [2,1]
        print(prob.swapNodes(build(new int[]{1,2,3}), 2)); // [1,2,3]
    }
}

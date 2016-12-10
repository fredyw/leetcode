package leetcode;

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
        // TODO
        return null;
    }

    private static void print(ListNode node) {
        for (ListNode n = node; n != null; n = n.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem23 prob = new Problem23();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(9);
        list2.next.next.next = new ListNode(10);
        list2.next.next.next.next = new ListNode(12);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(8);
        list3.next.next.next = new ListNode(11);

        ListNode result = prob.mergeKLists(new ListNode[]{list1, list2, list3});
        print(result);
    }
}

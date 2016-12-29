package leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class Problem445 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem445 prob = new Problem445();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(prob.addTwoNumbers(l1, l2));
    }
}

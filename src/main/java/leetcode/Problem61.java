package leetcode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class Problem61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 0;
        for (ListNode node = head; node != null; node = node.next) {
            size++;
        }
        if (size <= k) {
            return head;
        }
        int n = size - k - 1;
        ListNode node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        ListNode tail = newHead.next;
        if (tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        if (tail != null) {
            tail.next = head;
        } else {
            newHead.next = head;
        }
        return newHead;
    }
    
    public static void main(String[] args) {
        Problem61 prob = new Problem61();
        
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);
            node = prob.rotateRight(node, i);
            for (ListNode n = node; n != null; n = n.next) {
                System.out.print(n.val + " ");
            }
            System.out.println();
        }
    }
}

package leetcode;

import java.awt.List;

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
        return head;
    }
    
    public static void main(String[] args) {
        Problem61 prob = new Problem61();
        
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        
        node = prob.rotateRight(node, 2);
        for (ListNode n = node; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }
}

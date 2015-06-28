package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Problem206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode node = head ; node != null; node = node.next) {
            stack.push(node);
        }
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            n1 = stack.pop();
            if (newHead == null) {
                newHead = n1;
            }
            if (stack.isEmpty()) {
                break;
            }
            n2 = stack.pop();
            n1.next = n2;
            n2.next = null;
            stack.push(n2);
        }
        return newHead;
    }
}

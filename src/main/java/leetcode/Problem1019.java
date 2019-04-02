package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class Problem1019 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            list.add(n.val);
        }
        int[] answer = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek();
            }
            stack.add(list.get(i));
        }
        return answer;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class Problem1171 {
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

    public ListNode removeZeroSumSublists(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            nodes.add(n);
        }
        Set<Integer> removed = new HashSet<>();
        // TODO
        int i = 0;
        while (i < nodes.size() && removed.contains(i)) {
            i++;
        }
        ListNode answer = null;
        if (i < nodes.size()) {
            answer = nodes.get(i);
        }
        ListNode next = answer;
        for (; i < nodes.size() - 1; i++) {
            if (!removed.contains(i + 1)) {
                next.next = nodes.get(i + 1);
                next = next.next;
            }
            next.next = null;
        }
        return answer;
    }

    private static void print(ListNode head) {
        System.out.print("[ ");
        for (ListNode n = head; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Problem1171 prob = new Problem1171();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        print(prob.removeZeroSumSublists(head)); // [3,1]

//        head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(-3);
//        head.next.next.next.next = new ListNode(4);
//        print(prob.removeZeroSumSublists(head)); // [1,2,4]
//
//        head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(-3);
//        head.next.next.next.next = new ListNode(-2);
//        print(prob.removeZeroSumSublists(head)); // [1]
//
//        head = new ListNode(3);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(-2);
//        head.next.next.next.next = new ListNode(-3);
//        head.next.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next.next = new ListNode(6);
//        print(prob.removeZeroSumSublists(head)); // [3, 2]
    }
}

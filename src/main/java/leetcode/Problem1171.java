package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int sum = 0;
        while (true) {
            Map</*sum*/ Integer, /*index*/ Integer> map = new HashMap<>();
            int startIdx = 0;
            int endIdx = 0;
            sum = 0;
            boolean removed =  false;
            for (int i = 0; i < nodes.size(); i++) {
                sum += nodes.get(i).val;
                if (map.containsKey(sum)) {
                    startIdx = map.get(sum) + 1;
                    endIdx = i;
                    removed = true;
                    break;
                } else {
                    map.put(sum, i);
                }
            }
            if (!removed) {
                break;
            }
            List<ListNode> tmp = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                if (i < startIdx || i > endIdx) {
                    tmp.add(nodes.get(i));
                }
            }
            nodes = tmp;
        }
        if (sum == 0) {
            return null;
        }
        ListNode answer = null;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).val == 0) {
                continue;
            }
            if (answer == null) {
                answer = nodes.get(i);
            } else {
                nodes.get(i - 1).next = nodes.get(i);
            }
            nodes.get(i).next = null;
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
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(-3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(1);
//        print(prob.removeZeroSumSublists(head)); // [3,1]
//
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
//
//        head = new ListNode(1);
//        head.next = new ListNode(-1);
//        print(prob.removeZeroSumSublists(head)); // []
//
//        head = new ListNode(0);
//        head.next = new ListNode(2);
//        print(prob.removeZeroSumSublists(head)); // [2]

        head = new ListNode(-1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(-1);
        print(prob.removeZeroSumSublists(head)); // [-2, -1]
    }
}

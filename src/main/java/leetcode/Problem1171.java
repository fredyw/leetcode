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
                } if (sum == 0) {
                    startIdx = 0;
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
        ListNode answer = null;
        for (int i = 0; i < nodes.size(); i++) {
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
}

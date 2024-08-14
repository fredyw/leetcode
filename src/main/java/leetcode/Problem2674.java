package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/split-a-circular-linked-list/
public class Problem2674 {
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

    public ListNode[] splitCircularLinkedList(ListNode list) {
        List<ListNode> nodes = new ArrayList<>();
        for (var node = list; node != null; node = node.next) {
            if (!nodes.isEmpty() && node == list) {
                break;
            }
            nodes.add(node);
        }
        var first = nodes.getFirst();
        if (nodes.size() % 2 == 0) {
            nodes.get((nodes.size() / 2) - 1).next = first;
        } else {
            nodes.get(nodes.size() / 2).next = first;
        }
        var second = nodes.get((int) Math.ceil((double) nodes.size() / 2));
        nodes.getLast().next = second;
        return new ListNode[]{first, second};
    }
}

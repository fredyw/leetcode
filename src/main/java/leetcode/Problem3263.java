package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/convert-doubly-linked-list-to-array-i/description/
public class Problem3263 {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    public int[] toArray(Node head) {
        List<Integer> answer = new ArrayList<>();
        for (var node = head; node != null; node = node.next) {
            answer.add(node.val);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

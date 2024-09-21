package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii/
public class Problem3294 {
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    public int[] toArray(Node node) {
        var head = node;
        while (head.prev != null) {
            head = head.prev;
        }
        List<Integer> answer = new ArrayList<>();
        for (var n = head; n != null; n = n.next) {
            answer.add(n.val);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class Problem430 {
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem430 prob = new Problem430();
    }
}

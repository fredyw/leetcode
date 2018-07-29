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
        for (Node n = head; n != null; n = n.next) {
            if (n.child != null) {
                Node tmp = n.next;
                Node cn = flatten(n.child);
                n.next = cn;
                cn.prev = n;
                n.child = null;
                while (cn.next != null) {
                    cn = cn.next;
                }
                cn.next = tmp;
                if (tmp != null) {
                    tmp.prev = cn;
                }
            }
        }
        return head;
    }
}

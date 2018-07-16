package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class Problem590 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem590 prob = new Problem590();
    }
}

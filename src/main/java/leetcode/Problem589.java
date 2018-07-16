package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class Problem589 {
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private static void preOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            preOrder(node, result);
        }
    }
}

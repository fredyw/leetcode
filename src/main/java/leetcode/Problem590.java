package leetcode;

import java.util.ArrayList;
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
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private static void postOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postOrder(node, result);
        }
        result.add(root.val);
    }
}

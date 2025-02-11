package leetcode;

import java.util.List;

// https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
public class Problem431 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode encode(Node root) {
        // TODO
        return null;
    }

    public Node decode(TreeNode root) {
        // TODO
        return null;
    }
}

package leetcode;

/**
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Problem114 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        flatten(null, root);
    }

    private TreeNode flatten(TreeNode parent, TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (parent == null) {
            parent = node;
        } else {
            parent.left = null;
            parent.right = node;
        }
        if (node.left != null && node.right == null) {
            return flatten(node, left);
        } else if (node.left == null && node.right != null) {
            return flatten(node, right);
        } else if (node.left != null && node.right != null) {
            TreeNode l = flatten(node, left);
            return flatten(l, right);
        } else {
            return node;
        }
    }
}

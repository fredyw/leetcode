package leetcode;

/**
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class Problem110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        try {
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            return (Math.abs(left - right) <= 1);
        } catch (Exception e) {
            return false;
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getHeight(node.left);
        int y = getHeight(node.right);
        if (Math.abs(x - y) <= 1) {
            return Math.max(x, y) + 1;
        }
        throw new RuntimeException("Not balanced");
    }
}

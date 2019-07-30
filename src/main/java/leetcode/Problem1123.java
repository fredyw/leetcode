package leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Problem1123 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == right) {
            return root;
        }
        return left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

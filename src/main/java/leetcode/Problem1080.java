package leetcode;

/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class Problem1080 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return sufficientSubset(root, limit, 0);
    }

    private static TreeNode sufficientSubset(TreeNode root, int limit, int sum) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum >= limit ? root : null;
        }
        int newSum = root.val + sum;
        root.left = sufficientSubset(root.left, limit, newSum);
        root.right = sufficientSubset(root.right, limit, newSum);
        return root.left == null && root.right == null ? null : root;
    }
}

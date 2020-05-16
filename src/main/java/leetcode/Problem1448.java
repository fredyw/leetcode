package leetcode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class Problem1448 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private static int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int val = root.val >= max ? 1 : 0;
        return goodNodes(root.left, Math.max(max, root.val)) +
            goodNodes(root.right,  Math.max(max, root.val)) + val;
    }
}

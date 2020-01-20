package leetcode;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
public class Problem1325 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}

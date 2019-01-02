package leetcode;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class Problem965 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private static boolean isUnivalTree(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        return isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }
}

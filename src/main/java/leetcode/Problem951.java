package leetcode;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class Problem951 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if ((root1 == null && root2 != null) ||
            (root1 != null && root2 == null) ||
            (root1.val != root2.val)) {
            return false;
        }
        if ((root1.left == null && root2.left != null) ||
            (root1.left != null && root2.left == null) ||
            (root1.left != null && root2.right!= null && root1.left.val != root2.left.val)) {
            TreeNode tmp = root1.left;
            root1.left = root1.right;
            root1.right = tmp;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}

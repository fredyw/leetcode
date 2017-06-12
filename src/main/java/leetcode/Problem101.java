package leetcode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class Problem101 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        }
        return false;
    }
}

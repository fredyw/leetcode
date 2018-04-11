package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 */
public class Problem814 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean b = prune(root);
        if (b) {
            return null;
        }
        return root;
    }

    private static boolean prune(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean b1 = prune(root.left);
        boolean b2 = prune(root.right);
        if (b1) {
            if (root.left != null) {
                root.left = null;
            }
        }
        if (b2) {
            if (root.right != null) {
                root.right = null;
            }
        }
        return root.val == 0 && b1 && b2;
    }
}

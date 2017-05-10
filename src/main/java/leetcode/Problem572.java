package leetcode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class Problem572 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            boolean same = isSame(s, t);
            if (same) {
                return true;
            }
        }
        boolean a = isSubtree(s.left, t);
        boolean b = isSubtree(s.right, t);
        return a | b;
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        }
        if (s != null && t == null) {
            return false;
        }
        if (s == null && t == null) {
            return true;
        }
        if (s.val != t.val) {
            return false;
        }
        boolean left = isSame(s.left, t.left);
        boolean right = isSame(s.right, t.right);
        return left & right;
    }
}

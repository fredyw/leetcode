package leetcode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Problem617 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        merge(t1, t2);
        return t1;
    }

    private static void merge(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return;
        }
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
        }
        if (t1.left == null && t2.left != null) {
            t1.left = t2.left;
        } else {
            merge(t1.left, t2.left);
        }
        if (t1.right == null && t2.right != null) {
            t1.right = t2.right;
        } else {
            merge(t1.right, t2.right);
        }
    }
}

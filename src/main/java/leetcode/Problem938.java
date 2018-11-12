package leetcode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class Problem938 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        IntRef sum = new IntRef();
        inOrder(root, L, R, sum);
        return sum.sum;
    }

    private static class IntRef {
        private int sum;
    }

    private static void inOrder(TreeNode root, int l, int r, IntRef sum) {
        if (root == null) {
            return;
        }
        inOrder(root.left, l, r, sum);
        if (root.val >= l && root.val <= r) {
            sum.sum += root.val;
        }
        inOrder(root.right, l, r, sum);
    }
}

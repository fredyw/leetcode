package leetcode;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class Problem979 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int distributeCoins(TreeNode root) {
        IntRef ref = new IntRef();
        distributeCoins(root, ref);
        return ref.val;
    }

    private static class IntRef {
        private int val;
    }

    private static int distributeCoins(TreeNode root, IntRef ref) {
        if (root == null) {
            return 0;
        }
        int a = distributeCoins(root.left, ref);
        int b = distributeCoins(root.right, ref);
        ref.val += Math.abs(a) + Math.abs(b);
        return root.val + a + b - 1;
    }
}

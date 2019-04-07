package leetcode;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Problem1022 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        IntRef sum = new IntRef();
        sumRootToLeaf(root, "", sum);
        return sum.val;
    }

    private static class IntRef {
        private int val;
    }

    private static void sumRootToLeaf(TreeNode root, String s, IntRef sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            int n = Integer.parseInt(s + root.val, 2);
            sum.val += n;
        }
        sumRootToLeaf(root.left, s + root.val, sum);
        sumRootToLeaf(root.right, s + root.val, sum);
    }
}

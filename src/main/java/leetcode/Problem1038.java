package leetcode;

public class Problem1038 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        return bstToGst(root, new IntRef());
    }

    private static TreeNode bstToGst(TreeNode root, IntRef sum) {
        if (root == null) {
            return null;
        }
        root.right = bstToGst(root.right, sum);
        sum.val += root.val;
        root.val = sum.val;
        root.left = bstToGst(root.left, sum);
        return root;
    }

    private static class IntRef {
        private int val;
    }
}

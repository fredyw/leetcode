package leetcode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class Problem538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        return convertBST(root, new IntRef());
    }

    private static TreeNode convertBST(TreeNode root, IntRef sum) {
        if (root == null) {
            return null;
        }
        root.right = convertBST(root.right, sum);
        sum.val += root.val;
        root.val = sum.val;
        root.left = convertBST(root.left, sum);
        return root;
    }

    private static class IntRef {
        private int val;
    }
}

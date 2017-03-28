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
        if (root == null) {
            return root;
        }
        return convert(root, new Sum());
    }

    private static class Sum {
        private int val;
    }

    private static TreeNode convert(TreeNode node, Sum sum) {
        if (node.left == null && node.right == null) {
            sum.val += node.val;
            return new TreeNode(sum.val);
        }
        TreeNode right = null;
        if (node.right != null) {
            right = convert(node.right, sum);
        }
        sum.val += node.val;
        int val = sum.val;
        TreeNode left = null;
        if (node.left != null) {
            left = convert(node.left, sum);
        }
        TreeNode parent = new TreeNode(val);
        parent.left = left;
        parent.right = right;
        return parent;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class Problem1339 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxProduct(TreeNode root) {
        SumTreeNode rootSumTreeNode = build(root);
        LongRef answer = new LongRef();
        maxProduct(rootSumTreeNode, rootSumTreeNode.sum, answer);
        return (int) (answer.val % 1_000_000_007);
    }

    private static class SumTreeNode {
        private final long sum;
        private SumTreeNode left;
        private SumTreeNode right;

        public SumTreeNode(int sum) {
            this.sum = sum;
        }
    }

    private static class LongRef {
        private long val;
    }

    private static void maxProduct(SumTreeNode root, long totalSum, LongRef max) {
        if (root == null) {
            return;
        }
        long product = root.sum * (totalSum - root.sum);
        max.val = Math.max(max.val, product);
        maxProduct(root.left, totalSum, max);
        maxProduct(root.right, totalSum, max);
    }

    private static SumTreeNode build(TreeNode root) {
        if (root == null) {
            return null;
        }
        int sum = 0;
        SumTreeNode left = build(root.left);
        if (left != null) {
            sum += left.sum;
        }
        SumTreeNode right = build(root.right);
        if (right != null) {
            sum += right.sum;
        }
        SumTreeNode current = new SumTreeNode(sum + root.val);
        current.left = left;
        current.right = right;
        return current;
    }
}

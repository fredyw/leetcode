package leetcode;

/**
 * https://leetcode.com/problems/equal-tree-partition/
 */
public class Problem663 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return false;
        }
        int sum = sum(root);
        return checkEqualTree(root, sum).found;
    }

    private static int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + sum(node.right) + node.val;
    }

    private static FoundSum checkEqualTree(TreeNode node, int sum) {
        if (node == null) {
            return new FoundSum(false, 0);
        }
        FoundSum left = checkEqualTree(node.left, sum);
        FoundSum right = checkEqualTree(node.right, sum);
        boolean found = ((sum - left.sum) == left.sum) || ((sum - right.sum) == right.sum);
        return new FoundSum(left.found || right.found || found, left.sum + right.sum + node.val);
    }

    private static class FoundSum {
        private final boolean found;
        private final int sum;

        public FoundSum(boolean found, int sum) {
            this.found = found;
            this.sum = sum;
        }
    }
}

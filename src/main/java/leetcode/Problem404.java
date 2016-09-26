package leetcode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class Problem404 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        Sum sum = new Sum();
        if (root == null) {
            return sum.sum;
        }
        sumOfLeftLeaves(root, sum, Direction.CENTER);
        return sum.sum;
    }

    private static class Sum {
        private int sum;
    }

    private enum Direction {
        LEFT, RIGHT, CENTER
    }

    private void sumOfLeftLeaves(TreeNode root, Sum sum, Direction direction) {
        if (root.left == null && root.right == null && direction == Direction.LEFT) {
            sum.sum += root.val;
        }
        if (root.left != null) {
            sumOfLeftLeaves(root.left, sum, Direction.LEFT);
        }
        if (root.right != null) {
            sumOfLeftLeaves(root.right, sum, Direction.RIGHT);
        }
    }
}

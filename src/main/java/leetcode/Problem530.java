package leetcode;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class Problem530 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        MinDiff minDiff = new MinDiff();
        getMinimumDifference(root, minDiff);
        return minDiff.min;
    }

    private static class MinDiff {
        TreeNode node;
        int min = Integer.MAX_VALUE;
    }

    private static void getMinimumDifference(TreeNode node, MinDiff minDiff) {
        if (node == null) {
            return;
        }
        getMinimumDifference(node.left, minDiff);
        if (minDiff.node != null) {
            minDiff.min = Math.min(minDiff.min, Math.abs(minDiff.node.val - node.val));
        }
        minDiff.node = node;
        getMinimumDifference(node.right, minDiff);
    }
}

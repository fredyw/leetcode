package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class Problem337 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNodeWrapper, Integer> memo = new HashMap<>();
        int a = rob(root, false, memo);
        int b = rob(root, true, memo);
        return Math.max(a, b);
    }

    private static class TreeNodeWrapper {
        private TreeNode node;
        private boolean skipped;

        public TreeNodeWrapper(TreeNode node, boolean skipped) {
            this.node = node;
            this.skipped = skipped;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNodeWrapper that = (TreeNodeWrapper) o;
            return skipped == that.skipped &&
                Objects.equals(node, that.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, skipped);
        }
    }

    private int rob(TreeNode node, boolean skipped, Map<TreeNodeWrapper, Integer> memo) {
        if (node == null) {
            return 0;
        }
        TreeNodeWrapper tnw = new TreeNodeWrapper(node, skipped);
        if (memo.containsKey(tnw)) {
            return memo.get(tnw);
        }
        int max = 0;
        if (skipped) {
            int left1 = rob(node.left, skipped, memo); // continue skipping
            int left2 = rob(node.left, !skipped, memo); // start processing
            int maxLeft = Math.max(left1, left2);

            int right1 = rob(node.right, skipped, memo); // continue skipping
            int right2 = rob(node.right, !skipped, memo); // start processing
            int maxRight = Math.max(right1, right2);

            max = maxLeft + maxRight;
        } else { // not skipped
            int maxLeft = rob(node.left, !skipped, memo); // start skipping
            int maxRight = rob(node.right, !skipped, memo); // start skipping
            max = maxLeft + maxRight;
        }
        if (!skipped) {
            max += node.val;
        }
        memo.put(tnw, max);
        return max;
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class Problem1026 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        IntRef answer = new IntRef();
        maxAncestorDiff(root, answer);
        return answer.val;
    }

    private static class MinMax {
        private int min;
        private int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private static class IntRef {
        private int val;
    }

    private static MinMax maxAncestorDiff(TreeNode root, IntRef max) {
        if (root == null) {
            return null;
        }
        MinMax left = maxAncestorDiff(root.left, max);
        MinMax right = maxAncestorDiff(root.right, max);
        MinMax minMax = new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE);
        if (left != null) {
            minMax.min = Math.min(minMax.min, left.min);
            minMax.max = Math.max(minMax.max, left.max);
            int a = Math.abs(root.val - left.max);
            int b = Math.abs(root.val - left.min);
            max.val = Math.max(max.val, Math.max(a, b));
        }
        if (right != null) {
            minMax.min = Math.min(minMax.min, right.min);
            minMax.max = Math.max(minMax.max, right.max);
            int a = Math.abs(root.val - right.max);
            int b = Math.abs(root.val - right.min);
            max.val = Math.max(max.val, Math.max(a, b));
        }
        minMax.min = Math.min(minMax.min, root.val);
        minMax.max = Math.max(minMax.max, root.val);
        return minMax;
    }
}

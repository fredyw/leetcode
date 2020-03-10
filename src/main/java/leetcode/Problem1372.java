package leetcode;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class Problem1372 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestZigZag(TreeNode root) {
        IntRef answer = new IntRef();
        longestZigZag(root, answer);
        return answer.val - 1;
    }

    private static class IntRef {
        private int val;
    }

    private static class Count {
        private int left;
        private int right;

        public Count(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static Count longestZigZag(TreeNode root, IntRef max) {
        if (root == null) {
            return new Count(0, 0);
        }
        Count left = longestZigZag(root.left, max);
        Count right = longestZigZag(root.right, max);
        int leftCount = left.right + 1;
        int rightCount = right.left + 1;
        max.val = Math.max(max.val, Math.max(leftCount, rightCount));
        return new Count(leftCount, rightCount);
    }
}

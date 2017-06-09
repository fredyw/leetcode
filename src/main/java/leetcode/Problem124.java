package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Problem124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        Max max = new Max();
        maxPathSum(root, max);
        return max.value;
    }

    private static class Max {
        private int value = Integer.MIN_VALUE;
    }

    private static int maxPathSum(TreeNode node, Max max) {
        if (node == null) {
            return 0;
        }
        int a = maxPathSum(node.left, max);
        int b = maxPathSum(node.right, max);
        if (a + node.val < node.val) {
            a = 0;
        }
        if (b + node.val < node.val) {
            b = 0;
        }
        max.value = Math.max(max.value, a + b + node.val);
        return Math.max(node.val + a, node.val + b);
    }
}

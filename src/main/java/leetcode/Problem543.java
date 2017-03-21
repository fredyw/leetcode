package leetcode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class Problem543 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Max max = new Max();
        diameterOfBinaryTree(root, max);
        return max.max;
    }

    private static class Max {
        int max;
    }

    private static int diameterOfBinaryTree(TreeNode node, Max max) {
        if (node == null) {
            return 0;
        }
        int a = diameterOfBinaryTree(node.left, max);
        int b = diameterOfBinaryTree(node.right, max);
        max.max = Math.max(max.max, a + b);
        return Math.max(a, b) + 1;
    }
}

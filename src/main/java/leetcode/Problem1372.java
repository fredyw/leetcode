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
        return Math.max(longestZigZag(root, true), longestZigZag(root, false)) - 1;
    }

    private static int longestZigZag(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (left) {
            return longestZigZag(root.left, !left) + 1;
        }
        return longestZigZag(root.right, !left) + 1;
    }

    public static void main(String[] args) {
        Problem1372 prob = new Problem1372();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(prob.longestZigZag(root)); // 3
    }
}

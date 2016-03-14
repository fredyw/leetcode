package leetcode;

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
        // TODO
        int a = rob(root, false);
        int b = rob(root, true);
        System.out.println(a + " vs " + b);
        return Math.max(a, b);
    }

    private int rob(TreeNode node, boolean skip) {
        if (node == null) {
            return 0;
        }
        int val = 0;
        if (!skip) {
            val = node.val;
        }
        int a = rob(node.left, !skip);
        int b = rob(node.right, !skip);
        return a + b + val;
    }

    public static void main(String[] args) {
        Problem337 prob = new Problem337();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(prob.rob(root)); // 7

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        System.out.println(prob.rob(root)); // 9

        root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(prob.rob(root)); // 7
    }
}

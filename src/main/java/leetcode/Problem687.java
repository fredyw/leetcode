package leetcode;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class Problem687 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem687 prob = new Problem687();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(prob.longestUnivaluePath(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(prob.longestUnivaluePath(root)); // 2
    }
}

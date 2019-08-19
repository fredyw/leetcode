package leetcode;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class Problem1161 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1161 prob = new Problem1161();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(prob.maxLevelSum(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(100);
        System.out.println(prob.maxLevelSum(root)); // 3
    }
}

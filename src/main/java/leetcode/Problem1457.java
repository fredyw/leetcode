package leetcode;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class Problem1457 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1457 prob = new Problem1457();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(prob.pseudoPalindromicPaths(root)); // 2

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(prob.pseudoPalindromicPaths(root)); // 1

        root = new TreeNode(9);
        System.out.println(prob.pseudoPalindromicPaths(root)); // 1
    }
}

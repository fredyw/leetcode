package leetcode;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class Problem662 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem662 prob = new Problem662();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(prob.widthOfBinaryTree(root)); // 4

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(prob.widthOfBinaryTree(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);
        System.out.println(prob.widthOfBinaryTree(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        System.out.println(prob.widthOfBinaryTree(root)); // 8
    }
}

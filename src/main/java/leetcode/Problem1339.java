package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class Problem1339 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxProduct(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1339 prob = new Problem1339();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(prob.maxProduct(root)); // 110

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        System.out.println(prob.maxProduct(root)); // 90

        root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(prob.maxProduct(root)); // 1
    }
}

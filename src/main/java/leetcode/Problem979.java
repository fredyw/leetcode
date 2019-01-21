package leetcode;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */
public class Problem979 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int distributeCoins(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem979 prob = new Problem979();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(prob.distributeCoins(root)); // 2

        root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        System.out.println(prob.distributeCoins(root)); // 3

        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        System.out.println(prob.distributeCoins(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(0);
        System.out.println(prob.distributeCoins(root)); // 4
    }
}

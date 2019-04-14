package leetcode;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class Problem1026 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1026 prob = new Problem1026();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(prob.maxAncestorDiff(root)); // 7
    }
}

package leetcode;

/**
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class Problem1080 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1080 prob = new Problem1080();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(-99);
        root.left.right.left = new TreeNode(-99);
        root.left.right.right = new TreeNode(-99);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-99);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(-99);
        root.right.right.right = new TreeNode(14);

        root = prob.sufficientSubset(root, 1);

        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(3);

        root = prob.sufficientSubset(root, 22);
    }
}

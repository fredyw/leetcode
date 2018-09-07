package leetcode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class Problem897 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem897 prob = new Problem897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        System.out.println(prob.increasingBST(root));
    }
}

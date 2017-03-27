package leetcode;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class Problem538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        // TODO
        return root;
    }

    public static void main(String[] args) {
        Problem538 prob = new Problem538();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        System.out.println(prob.convertBST(root));
    }
}

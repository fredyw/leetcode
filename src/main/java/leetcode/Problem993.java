package leetcode;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class Problem993 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem993 prob = new Problem993();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(prob.isCousins(root, 4, 3)); // false

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(prob.isCousins(root, 5, 4)); // true

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(prob.isCousins(root, 2, 3)); // false
    }
}

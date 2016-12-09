package leetcode;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class Problem99 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        // TODO
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void print(TreeNode root) {
        inOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        Problem99 prob = new Problem99();

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);

        prob.recoverTree(root);
        print(root);
    }
}

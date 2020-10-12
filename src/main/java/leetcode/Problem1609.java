package leetcode;

/**
 * https://leetcode.com/problems/even-odd-tree/
 */
public class Problem1609 {
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

    public boolean isEvenOddTree(TreeNode root) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1609 prob = new Problem1609();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);
        System.out.println(prob.isEvenOddTree(root)); // true

        root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(7);
        System.out.println(prob.isEvenOddTree(root)); // false

        root = new TreeNode(1);
        System.out.println(prob.isEvenOddTree(root)); // true
    }
}

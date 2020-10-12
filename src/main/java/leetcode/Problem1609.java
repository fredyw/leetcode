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
    }
}

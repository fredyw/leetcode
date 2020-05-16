package leetcode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class Problem1448 {
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

    public int goodNodes(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1448 prob = new Problem1448();
    }
}

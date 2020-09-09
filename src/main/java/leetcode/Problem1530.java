package leetcode;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class Problem1530 {
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

    public int countPairs(TreeNode root, int distance) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1530 prob = new Problem1530();
    }
}

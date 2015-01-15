package leetcode;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class Problem129 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // this is a trick for using reference to
        // avoid having a member variable
        int[] result = new int[1];
        sumNumbers(root, "", result);
        return result[0];
    }
    
    private void sumNumbers(TreeNode node, String accu, int[] result) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            int value = Integer.parseInt(accu + node.val);
            result[0] = result[0] + value;
            return;
        }
        sumNumbers(node.left, accu + Integer.toString(node.val), result);
        sumNumbers(node.right, accu + Integer.toString(node.val), result);
    }
}

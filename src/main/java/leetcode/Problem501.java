package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class Problem501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem501 prob = new Problem501();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        System.out.println(Arrays.toString(prob.findMode(root))); // [1,2]
    }
}

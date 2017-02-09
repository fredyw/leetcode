package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */
public class Problem508 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem508 prob = new Problem508();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(prob.findFrequentTreeSum(root))); // [2, -3, 4]

        root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        System.out.println(Arrays.toString(prob.findFrequentTreeSum(root))); // [2]
    }
}

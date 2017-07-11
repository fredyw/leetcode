package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class Problem637 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem637 prob = new Problem637();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(prob.averageOfLevels(root)); // [3, 14.5, 11]
    }
}

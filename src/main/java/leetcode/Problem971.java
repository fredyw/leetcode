package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */
public class Problem971 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> answer = new ArrayList<>();
        // TODO
        return answer;
    }

    public static void main(String[] args) {
        Problem971 prob = new Problem971();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(prob.flipMatchVoyage(root, new int[]{2, 1})); // [-1]

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(prob.flipMatchVoyage(root, new int[]{1, 3, 2})); // [1]

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(prob.flipMatchVoyage(root, new int[]{1, 2, 3})); // []
    }
}

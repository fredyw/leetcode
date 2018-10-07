package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Problem863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem863 prob = new Problem863();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(prob.distanceK(root, root.left, 2)); // [7,4,1]
    }
}

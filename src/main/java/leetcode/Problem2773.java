package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/height-of-special-binary-tree/description/
public class Problem2773 {
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

    public int heightOfTree(TreeNode root) {
        Set<Integer> leaves = new HashSet<>();
        getLeaves(root, new HashSet<>(), leaves);
        return heightOfTree(root, leaves);
    }

    private static int heightOfTree(TreeNode root, Set<Integer> leaves) {
        if (root == null || leaves.contains(root.val)) {
            return 0;
        }
        int left = heightOfTree(root.left, leaves);
        int right = heightOfTree(root.right, leaves);
        return Integer.max(left, right) + 1;
    }

    private static void getLeaves(TreeNode root, Set<Integer> visited, Set<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (visited.contains(root.val)) {
            leaves.add(root.val);
            return;
        }
        visited.add(root.val);
        getLeaves(root.left, visited, leaves);
        getLeaves(root.right, visited, leaves);
    }
}

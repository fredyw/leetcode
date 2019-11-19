package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 */
public class Problem1261 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class FindElements {
        private final Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            traverse(root, 0, set);
        }

        private static void traverse(TreeNode root, int value, Set<Integer> set) {
            if (root == null) {
                return;
            }
            set.add(value);
            traverse(root.left, 2 * value + 1, set);
            traverse(root.right, 2 * value + 2, set);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}

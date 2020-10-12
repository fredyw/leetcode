package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/even-odd-tree/
 */
public class Problem1609 {
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

    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode previous = null;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (level % 2 == 0) { // even
                    if (current.val % 2 == 0) { // must have odd number
                        return false;
                    }
                    // must have strictly increasing order
                    if (previous != null && previous.val >= current.val) {
                        return false;
                    }
                } else { // odd
                    if (current.val % 2 != 0) { // must have even number
                        return false;
                    }
                    // must have strictly decreasing order
                    if (previous != null && previous.val <= current.val) {
                        return false;
                    }
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                previous = current;
            }
            level++;
        }
        return true;
    }
}

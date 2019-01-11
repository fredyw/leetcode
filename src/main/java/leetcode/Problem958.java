package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class Problem958 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean done = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (done && node.left != null) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
            } else {
                done = true;
            }
            if (done && node.right != null) {
                return false;
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                done = true;
            }
        }
        return true;
    }
}

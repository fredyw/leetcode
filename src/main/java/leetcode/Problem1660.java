package leetcode;

import java.util.HashSet;

// https://leetcode.com/problems/correct-a-binary-tree/description/
public class Problem1660 {
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

    public TreeNode correctBinaryTree(TreeNode root) {
        correctBinaryTree(root, null, Direction.CENTER, new HashSet<>());
        return root;
    }

    private enum Direction {
        CENTER, LEFT, RIGHT
    }

    private static void correctBinaryTree(TreeNode node,
                                          TreeNode parent,
                                          Direction direction,
                                          HashSet<Integer> set) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            if (set.contains(node.right.val)) {
                if (direction == Direction.LEFT) {
                    parent.left = null;
                } else if (direction == Direction.RIGHT) {
                    parent.right = null;
                }
            } else {
                correctBinaryTree(node.right, node, Direction.RIGHT, set);
            }
        }
        if (node.left != null) {
            if (set.contains(node.left.val)) {
                if (direction == Direction.LEFT) {
                    parent.left = null;
                } else if (direction == Direction.RIGHT) {
                    parent.right = null;
                }
            } else {
                correctBinaryTree(node.left, node, Direction.LEFT, set);
            }
        }
        set.add(node.val);
    }
}

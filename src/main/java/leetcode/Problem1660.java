package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, 0, map);
        correctBinaryTree(root, null, Direction.CENTER, map);
        return root;
    }

    private static void traverse(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, level);
        traverse(root.left, level + 1, map);
        traverse(root.right, level + 1, map);
    }

    private enum Direction {
        CENTER, LEFT, RIGHT
    }

    private static void correctBinaryTree(TreeNode node,
                                          TreeNode parent,
                                          Direction direction,
                                          Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (Objects.equals(map.get(node.val), map.get(node.left.val))) {
                if (direction == Direction.LEFT) {
                    parent.left = null;
                } else if (direction == Direction.RIGHT) {
                    parent.right = null;
                }
            } else {
                correctBinaryTree(node.left, node, Direction.LEFT, map);
            }
        }
        if (node.right != null) {
            if (Objects.equals(map.get(node.val), map.get(node.right.val))) {
                if (direction == Direction.LEFT) {
                    parent.left = null;
                } else if (direction == Direction.RIGHT) {
                    parent.right = null;
                }
            } else {
                correctBinaryTree(node.right, node, Direction.RIGHT, map);
            }
        }
    }
}

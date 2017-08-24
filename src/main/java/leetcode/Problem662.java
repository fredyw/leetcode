package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class Problem662 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        int height = height(root);
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(1, root));
        int level = 1;
        List<NodeLevel> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            NodeLevel current = queue.remove();
            if (level < current.level) {
                level = current.level;
                max = Math.max(max, count(tmp));
                tmp = new ArrayList<>();
            }
            tmp.add(current);
            if (current.level < height) {
                if (current.node != null) {
                    if (current.node.left != null) {
                        NodeLevel n = new NodeLevel(current.level + 1, current.node.left);
                        queue.add(n);
                    } else {
                        NodeLevel n = new NodeLevel(current.level + 1, null);
                        queue.add(n);
                    }
                    if (current.node.right != null) {
                        NodeLevel n = new NodeLevel(current.level + 1, current.node.right);
                        queue.add(n);
                    } else {
                        NodeLevel n = new NodeLevel(current.level + 1, null);
                        queue.add(n);
                    }
                } else {
                    queue.add(new NodeLevel(current.level + 1, null)); // left
                    queue.add(new NodeLevel(current.level + 1, null)); // right
                }
            }
        }
        max = Math.max(max, count(tmp));
        return max;
    }

    private static int count(List<NodeLevel> list) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < list.size(); i++) {
            NodeLevel nodeLevel = list.get(i);
            if (nodeLevel.node != null) {
                if (idx == -1) {
                    count++;
                } else {
                    count += i - idx;
                }
                idx = i;
            }
        }
        return count;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private static class NodeLevel {
        private final int level;
        private final TreeNode node;

        public NodeLevel(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }

        @Override
        public String toString() {
            return "" + ((node == null) ? "null" : node.val);
        }
    }

    public static void main(String[] args) {
        Problem662 prob = new Problem662();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(prob.widthOfBinaryTree(root)); // 4

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        System.out.println(prob.widthOfBinaryTree(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);
        System.out.println(prob.widthOfBinaryTree(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        System.out.println(prob.widthOfBinaryTree(root)); // 8
    }
}

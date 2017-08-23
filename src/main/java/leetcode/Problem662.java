package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        int height = height(root);
        Queue<NodeLevel> queue = new LinkedList<>();
        Map<Integer, List<NodeLevel>> map = new HashMap<>();
        map.put(1, Arrays.asList(new NodeLevel(1, root)));
        queue.add(new NodeLevel(1, root));
        while (!queue.isEmpty()) {
            NodeLevel current = queue.remove();
            if (current.level < height) {
                if (current.node != null) {
                    if (!map.containsKey(current.level + 1)) {
                        map.put(current.level + 1, new ArrayList<>());
                    }
                    List<NodeLevel> list = map.get(current.level + 1);
                    if (current.node.left != null) {
                        NodeLevel n = new NodeLevel(current.level + 1, current.node.left);
                        list.add(n);
                        queue.add(n);
                    } else {
                        NodeLevel n = new NodeLevel(current.level + 1, null);
                        list.add(n);
                        queue.add(n);
                    }
                    if (current.node.right != null) {
                        NodeLevel n = new NodeLevel(current.level + 1, current.node.right);
                        list.add(n);
                        queue.add(n);
                    } else {
                        NodeLevel n = new NodeLevel(current.level + 1, null);
                        list.add(n);
                        queue.add(n);
                    }
                } else {
                    if (!map.containsKey(current.level + 1)) {
                        map.put(current.level + 1, new ArrayList<>());
                    }
                    List<NodeLevel> list = map.get(current.level + 1);
                    list.add(new NodeLevel(current.level + 1, null)); // left
                    list.add(new NodeLevel(current.level + 1, null)); // right
                    queue.add(new NodeLevel(current.level + 1, null)); // left
                    queue.add(new NodeLevel(current.level + 1, null)); // right
                }
            }
        }
        int max = 0;
        for (Map.Entry<Integer, List<NodeLevel>> entry : map.entrySet()) {
            List<NodeLevel> list = entry.getValue();
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
            max = Math.max(max, count);
        }
        return max;
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

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
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(1, root, 1));
        int level = 1;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            NodeLevel current = queue.remove();
            if (level < current.level) {
                level = current.level;
                max = Math.max(max, count(tmp));
                tmp = new ArrayList<>();
            }
            tmp.add(current.position);
            if (current.node != null) {
                if (current.node.left != null) {
                    NodeLevel n = new NodeLevel(current.level + 1, current.node.left, 2 * current.position);
                    queue.add(n);
                }
                if (current.node.right != null) {
                    NodeLevel n = new NodeLevel(current.level + 1, current.node.right, (2 * current.position) + 1);
                    queue.add(n);
                }
            }
        }
        max = Math.max(max, count(tmp));
        return max;
    }

    private static int count(List<Integer> list) {
        return list.get(list.size() - 1) - list.get(0) + 1;
    }

    private static class NodeLevel {
        private final int level;
        private final TreeNode node;
        private final int position;

        public NodeLevel(int level, TreeNode node, int position) {
            this.level = level;
            this.node = node;
            this.position = position;
        }
    }
}

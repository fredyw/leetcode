package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class Problem637 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, ValueCount> map = new HashMap<>();
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(1, root));
        while (!queue.isEmpty()) {
            LevelNode current = queue.remove();
            if (!map.containsKey(current.level)) {
                map.put(current.level, new ValueCount(current.node.val, 1));
            } else {
                ValueCount valueCount = map.get(current.level);
                valueCount.count++;
                valueCount.value += current.node.val;
            }
            if (current.node.left != null) {
                queue.add(new LevelNode(current.level + 1, current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new LevelNode(current.level + 1, current.node.right));
            }
        }
        List<Double> result = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            ValueCount valueCount = map.get(i);
            result.add((double) valueCount.value / (double) valueCount.count);
        }
        return result;
    }

    private static class ValueCount {
        private long value;
        private int count;

        public ValueCount(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private static class LevelNode {
        private final int level;
        private final TreeNode node;

        public LevelNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}

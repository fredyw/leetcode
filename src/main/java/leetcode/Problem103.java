package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Problem103 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<LevelTreeNode> queue = new LinkedList<>();
        queue.add(new LevelTreeNode(1, root));
        while (!queue.isEmpty()) {
            LevelTreeNode ltn = queue.remove();
            if (!map.containsKey(ltn.level)) {
                List<Integer> list = new ArrayList<>();
                list.add(ltn.node.val);
                map.put(ltn.level, list);
            } else {
                map.get(ltn.level).add(ltn.node.val);
            }
            if (ltn.node.left != null) {
                queue.add(new LevelTreeNode(ltn.level + 1, ltn.node.left));
            }
            if (ltn.node.right != null) {
                queue.add(new LevelTreeNode(ltn.level + 1, ltn.node.right));
            }
        }
        boolean leftToRight = true;
        for (int i = 1; i <= map.size(); i++) {
            if (leftToRight) {
                result.add(map.get(i));
                leftToRight = false;
            } else {
                List<Integer> list = map.get(i);
                Collections.reverse(list);
                result.add(list);
                leftToRight = true;
            }
        }
        return result;
    }

    private static class LevelTreeNode {
        private final int level;
        private final TreeNode node;

        public LevelTreeNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}

package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class Problem449 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    private static class LevelNode {
        private final int level;
        private final TreeNode node;

        public LevelNode(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }

        @Override
        public String toString() {
            return level + ":" + ((node == null) ? "#" : node.val);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(1, root));
        while (!queue.isEmpty()) {
            LevelNode current = queue.remove();
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append(current);
            if (current.node == null) {
                continue;
            }
            queue.add(new LevelNode(current.level + 1, current.node.left));
            queue.add(new LevelNode(current.level + 1, current.node.right));
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Map<Integer, LinkedList<String>> map = new HashMap<>();
        String[] nodes = data.split("\\|");
        for (String node : nodes) {
            String[] levelNode = node.split(":");
            int level = Integer.parseInt(levelNode[0]);
            if (!map.containsKey(level)) {
                LinkedList list = new LinkedList();
                list.add(levelNode[1]);
                map.put(level, list);
            } else {
                map.get(level).add(levelNode[1]);
            }
        }
        return deserialize(map, 1);
    }

    private static TreeNode deserialize(Map<Integer, LinkedList<String>> map, int level) {
        LinkedList<String> list = map.get(level);
        if (list == null || list.isEmpty()) {
            return null;
        }
        String val = list.remove();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(map, level + 1);
        node.right = deserialize(map, level + 1);
        return node;
    }
}

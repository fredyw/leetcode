package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Problem116 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    private static class LevelNode {
        final int level;
        final TreeLinkNode node;

        public LevelNode(int level, TreeLinkNode node) {
            this.level = level;
            this.node = node;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(1, root));
        Map<Integer, TreeLinkNode> map = new HashMap<>();
        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.remove();
            int level = levelNode.level;
            TreeLinkNode left = levelNode.node.left;
            TreeLinkNode right = levelNode.node.right;
            if (left == null || right == null) {
                continue;
            }
            queue.add(new LevelNode(level + 1, left));
            queue.add(new LevelNode(level + 1, right));
            if (map.containsKey(level + 1)) {
                TreeLinkNode node = map.get(level + 1);
                node.next = left;
            }
            left.next = right;
            map.put(level + 1, right);
        }
    }
}

package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Problem117 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Map<Integer, TreeLinkNode> map = new HashMap<>();
        LinkedList<TreeLinkNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeLinkNodeLevel(1, root));
        while (!queue.isEmpty()) {
            TreeLinkNodeLevel current = queue.remove();
            TreeLinkNode previous = map.get(current.level);
            if (previous != null) {
                previous.next = current.node;
            }
            map.put(current.level, current.node);
            if (current.node.left != null) {
                queue.add(new TreeLinkNodeLevel(current.level + 1, current.node.left));
            }
            if (current.node.right != null) {
                queue.add(new TreeLinkNodeLevel(current.level + 1, current.node.right));
            }
        }
    }

    private static class TreeLinkNodeLevel {
        private final int level;
        private final TreeLinkNode node;

        public TreeLinkNodeLevel(int level, TreeLinkNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
